#ifdef GL_ES
# define LOWP       lowp
# define MEDIUMP    mediump
#else
# define LOWP    
# define MEDIUMP   
#endif
// #import "MatDefs/pmd/Skinning.glsllib"
#ifdef USE_HWSKINNING
uniform mat4 m_BoneMatrices[NUM_BONES];
#endif
#define ATTENUATION
// #define HQ_ATTENUATION

uniform mat4 g_WorldViewProjectionMatrix;
uniform mat4 g_WorldViewMatrix;
uniform mat3 g_NormalMatrix;
uniform mat4 g_ViewMatrix;

uniform LOWP vec4 m_Ambient;
uniform LOWP vec4 m_Diffuse;
uniform LOWP vec4 m_Specular;
uniform LOWP float m_Shininess;

uniform LOWP vec4 g_LightColor;
uniform vec4 g_LightPosition;
uniform LOWP vec4 g_AmbientLightColor;

varying LOWP vec2 texCoord;

varying LOWP vec4 AmbientSum;
varying LOWP vec4 DiffuseSum;
varying LOWP vec4 SpecularSum;

attribute vec3 inPosition;
attribute LOWP vec2 inTexCoord;
attribute vec3 inNormal;

// uniform Sampler2D m_BoneParameter;
// uniform sampler2D m_BoneParameter;

#ifdef HQ_ATTENUATION
  varying vec3 lightVec;
#endif

#ifdef VERTEX_COLOR
  attribute LOWP vec4 inColor;
#endif

#ifndef VERTEX_LIGHTING
  attribute vec4 inTangent;

  #ifndef NORMALMAP
    varying vec3 vNormal;
  #endif
  varying vec3 vPosition;
  varying vec3 vViewDir;
  varying vec4 vLightDir;
#endif

// #ifdef USE_REFLECTION
    uniform vec3 g_CameraPosition;
    uniform mat4 g_WorldMatrix;

    uniform vec3 m_FresnelParams;
    varying vec4 refVec;


    /**
     * Input:
     * attribute inPosition
     * attribute inNormal
     * uniform g_WorldMatrix
     * uniform g_CameraPosition
     *
     * Output:
     * varying refVec
     */
    void computeRef(in vec4 position, in vec4 normal){
        vec3 worldPos = (g_WorldMatrix * position).xyz;

        vec3 I = normalize( worldPos - g_CameraPosition    ).xyz;
        vec3 N = normalize( (g_WorldMatrix * normal).xyz );

        refVec.xyz = reflect(I, N);
        refVec.w   = 1.0;//m_FresnelParams.x + m_FresnelParams.y * pow(1.0 + dot(I, N), m_FresnelParams.z);
    }
// #endif

// JME3 lights in world space
void lightComputeDir(in vec3 worldPos, in vec4 color, in vec4 position, out vec4 lightDir){
    float posLight = step(0.5, color.w);
    vec3 tempVec = position.xyz * sign(posLight - 0.5) - (worldPos * posLight);
    #ifdef ATTENUATION
     float dist = length(tempVec);
     lightDir.w = clamp(1.0 - position.w * dist * posLight, 0.0, 1.0);
     lightDir.xyz = tempVec / vec3(dist);
     #ifdef HQ_ATTENUATION
       lightVec = tempVec;
     #endif
    #else
     lightDir = vec4(normalize(tempVec), 1.0);
    #endif
}

#ifdef VERTEX_LIGHTING
  float lightComputeDiffuse(in vec3 norm, in vec3 lightdir){
      return max(0.0, dot(norm, lightdir));
  }

  float lightComputeSpecular(in vec3 norm, in vec3 viewdir, in vec3 lightdir, in float shiny){
      #ifndef LOW_QUALITY
        vec3 H = (viewdir + lightdir) * vec3(0.5);
        return pow(max(dot(H, norm), 0.0), shiny);
      #else
        return 0.0;
      #endif
  }

vec2 computeLighting(in vec3 wvPos, in vec3 wvNorm, in vec3 wvViewDir, in vec4 wvLightPos){
     vec4 lightDir;
     lightComputeDir(wvPos, g_LightColor, wvLightPos, lightDir);

     float diffuseFactor = lightComputeDiffuse(wvNorm, lightDir.xyz);
     float specularFactor = 0.0;
     if (m_Shininess != 0.0) {
        specularFactor = lightComputeSpecular(wvNorm, wvViewDir, lightDir.xyz, m_Shininess);
     }
     //specularFactor *= step(0.01, diffuseFactor);
     return vec2(diffuseFactor, specularFactor) * vec2(lightDir.w);
  }
#endif
attribute vec2 inBoneWeight;
attribute vec2 inBoneIndex;
#ifdef USE_HWSKINNING
void Skinning_Compute(inout vec4 position, inout vec4 normal){
//    vec4 index  = inBoneIndices;
    vec2 index  = inBoneIndex;
    vec2 weight = inBoneWeight;

    vec4 newPos;
    vec4 newNormal;

    //for (float i = 1.0; i < 2.0; i += 1.0){
        mat4 skinMat;
#if NUM_BONES != 1
    skinMat = m_BoneMatrices[int(index.x)];
    newPos    = weight.x * (skinMat * position);
    newNormal = weight.x * (skinMat * normal);

    skinMat = m_BoneMatrices[int(index.y)];
    newPos    = newPos + weight.y * (skinMat * position);
    newNormal = newNormal + weight.y * (skinMat * normal);
#else
    skinMat = m_BoneMatrices[0];
    newPos    = (skinMat * position);
    newNormal = (skinMat * normal);
#endif
        //index = index.yzwx;
        //weight = weight.yzwx;
    //}

    position = newPos;
    normal = newNormal;
}
#endif
void main(){
   vec4 pos = vec4(inPosition, 1.0);
   vec4 normal = vec4(inNormal,0.0);
#ifdef USE_HWSKINNING
   Skinning_Compute(pos, normal);
#endif
//    pos = m_BoneMatrices[0] * pos;
   gl_Position = g_WorldViewProjectionMatrix * pos;
   texCoord = inTexCoord;

   vec3 wvPosition = (g_WorldViewMatrix * pos).xyz;
   vec3 wvNormal  = normalize(g_NormalMatrix * normal.xyz);

//   vec3 wvPosition = (g_WorldViewMatrix * pos).xyz;
//   vec3 wvNormal  = normalize(g_NormalMatrix * inNormal);

   vec3 viewDir = normalize(-wvPosition);

       //vec4 lightColor = g_LightColor[gl_InstanceID];
       //vec4 lightPos   = g_LightPosition[gl_InstanceID];
       //vec4 wvLightPos = (g_ViewMatrix * vec4(lightPos.xyz, lightColor.w));
       //wvLightPos.w = lightPos.w;

   vec4 wvLightPos = (g_ViewMatrix * vec4(g_LightPosition.xyz, g_LightColor.w));
   wvLightPos.w = g_LightPosition.w;
   LOWP vec4 lightColor = g_LightColor;

   #if defined(NORMALMAP) && !defined(VERTEX_LIGHTING)
     vec3 wvTangent = normalize(g_NormalMatrix * inTangent.xyz);
     vec3 wvBinormal = cross(wvNormal, wvTangent);

     mat3 tbnMat = mat3(wvTangent, wvBinormal * -inTangent.w,wvNormal);
     
     vPosition = wvPosition * tbnMat;
     vViewDir  = viewDir * tbnMat;
     lightComputeDir(wvPosition, lightColor, wvLightPos, vLightDir);
     vLightDir.xyz = (vLightDir.xyz * tbnMat).xyz;
   #elif !defined(VERTEX_LIGHTING)
     vNormal = wvNormal;

     vPosition = wvPosition;
     vViewDir = viewDir;

     lightComputeDir(wvPosition, lightColor, wvLightPos, vLightDir);

     #ifdef V_TANGENT
        vNormal = normalize(g_NormalMatrix * inTangent.xyz);
        vNormal = -cross(cross(vLightDir.xyz, vNormal), vNormal);
     #endif
   #endif

   lightColor.w = 1.0;
   #ifdef MATERIAL_COLORS
      AmbientSum  = m_Ambient  * g_AmbientLightColor;
      DiffuseSum  = m_Diffuse  * lightColor;
      SpecularSum = m_Specular * lightColor;
    #else
      AmbientSum  = /*vec4(0.2, 0.2, 0.2, 1.0) * */g_AmbientLightColor; // Default: ambient color is dark gray
      DiffuseSum  = lightColor;
      SpecularSum = lightColor;
    #endif

    #ifdef VERTEX_COLOR
      AmbientSum *= inColor;
      DiffuseSum *= inColor;
    #endif

    #ifdef VERTEX_LIGHTING
       vec2 light = computeLighting(wvPosition, wvNormal, viewDir, wvLightPos);

       AmbientSum.a  = light.x;
       SpecularSum.a = light.y /* * 0.3*/;
    #endif

    #if defined(USE_REFLECTION) || defined(SPHERE_MAP_A) || defined(SPHERE_MAP_H)
        computeRef(pos,normal);
    #endif 
}
