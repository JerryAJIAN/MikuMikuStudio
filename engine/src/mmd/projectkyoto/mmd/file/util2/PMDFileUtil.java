/*
 * Copyright (c) 2010-2014, Kazuhiko Kobayashi
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package projectkyoto.mmd.file.util2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import projectkyoto.mmd.file.DataInputStreamLittleEndian;
import projectkyoto.mmd.file.DataOutputStreamLittleEndian;
import projectkyoto.mmd.file.PMDModel;
import projectkyoto.mmd.file.PMDUtil;

/**
 *
 * @author kobayasi
 */
public class PMDFileUtil {
    public static final String PMDCACHE1HEADER = "PMDCACHEVer1";
    public static void makeMeshCache(PMDModel pmdModel, OutputStream os) throws IOException {
        MeshConverter mc = new MeshConverter(pmdModel);
        mc.convertMesh();
    }
    public static MeshConverter readPMDCache1(InputStream is) throws IOException {
        DataInputStreamLittleEndian dis = null;
        try {
            dis = new DataInputStreamLittleEndian(new BufferedInputStream(is));
            String version = dis.readString(20);
            if (!PMDCACHE1HEADER.equals(version)) {
                throw new IllegalArgumentException("Invalid header "+version);
            }
            int maxBoneSize = dis.readInt();
            PMDModel model = new PMDModel();
            model.readFromStream(dis);
            MeshConverter mc = new MeshConverter();
            mc.setModel(model);
            mc.read(dis);
            mc.setMaxBoneSize(maxBoneSize);
            return mc;
        } finally {
//            if (dis != null) {
//                dis.close();
//            }
        }
    }
    public static void writePMDCache1(PMDModel model, OutputStream os) throws IOException {
        MeshConverter mc = new MeshConverter(model);
        model.setFaceVertCount(0);
        model.setVertCount(0);
        DataOutputStreamLittleEndian dos = null;
        dos = new DataOutputStreamLittleEndian(os);
        // write header
        PMDUtil.writeString(dos, PMDCACHE1HEADER, 20);
        dos.writeInt(mc.getMaxBoneSize());
        model.writeToStream(dos);
        mc.convertMesh();
        mc.write(dos);
        dos.flush();
    }
    public static void writePMDCache1(PMDModel model, File file) throws IOException {
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            writePMDCache1(model, os);
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
    
    public static void createPmdcache1(File file) throws IOException{
        List<String> list = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(file.getName(), ".");
        while(st.hasMoreElements()) {
            String s = st.nextToken();
            list.add(s);
        }
        if (list.size() < 3) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        if (!list.get(list.size()-1).equals("pmdcache1")) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        File pmdFile = null;
        FileInputStream is = null;
        try {
            int boneSize = Integer.parseInt(list.get(list.size()-2));
            String fileName = file.getAbsolutePath();
            int delmCount = 0;
            for(int i=fileName.length()-1;i>0;i--) {
                if (fileName.charAt(i) == '.') {
                    delmCount++;
                    if (delmCount == 2) {
                        fileName = fileName.substring(0, i);
                        pmdFile = new File(fileName);
                        break;
                    }
                }
            }
            if (pmdFile != null) {
                System.out.println("pmdFile = "+pmdFile.getAbsolutePath());
                if (!pmdFile.exists()) {
                    throw new FileNotFoundException(file.getAbsolutePath());
                }
                MeshConverter.DEFAULT_MAX_BONE_SIZE = boneSize;
                is = new FileInputStream(pmdFile);
                PMDModel pmdModel = new PMDModel(is);
                writePMDCache1(pmdModel, file);
                return;
            }
        } catch(NumberFormatException ex) {
        } finally {
            if (is != null) {
                is.close();
            }
        }
        throw new FileNotFoundException(file.getAbsolutePath());
    }
    public static File getOriginalPMDFile(File file) throws IOException{
        List<String> list = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(file.getName(), ".");
        while(st.hasMoreElements()) {
            String s = st.nextToken();
            list.add(s);
        }
        if (list.size() < 3) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        if (!list.get(list.size()-1).equals("pmdcache1")) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        File pmdFile = null;
        FileInputStream is = null;
        try {
            int boneSize = Integer.parseInt(list.get(list.size()-2));
            String fileName = file.getAbsolutePath();
            int delmCount = 0;
            for(int i=fileName.length()-1;i>0;i--) {
                if (fileName.charAt(i) == '.') {
                    delmCount++;
                    if (delmCount == 2) {
                        fileName = fileName.substring(0, i);
                        pmdFile = new File(fileName);
                        break;
                    }
                }
            }
            if (pmdFile != null) {
                MeshConverter.DEFAULT_MAX_BONE_SIZE = boneSize;
                return pmdFile;
            }
        } catch(NumberFormatException ex) {
        } finally {
            if (is != null) {
                is.close();
            }
        }
        throw new FileNotFoundException(file.getAbsolutePath());
    }
}
