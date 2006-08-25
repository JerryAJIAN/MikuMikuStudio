/**
 * sphereType.java This file was generated by XMLSpy 2006sp2 Enterprise Edition.
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE OVERWRITTEN WHEN YOU
 * RE-RUN CODE GENERATION. Refer to the XMLSpy Documentation for further
 * details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

public class sphereType extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public sphereType(sphereType node) {
        super(node);
    }

    public sphereType(org.w3c.dom.Node node) {
        super(node);
    }

    public sphereType(org.w3c.dom.Document doc) {
        super(doc);
    }

    public sphereType(com.jmex.model.collada.xml.Document doc,
            String namespaceURI, String prefix, String name) {
        super(doc, namespaceURI, prefix, name);
    }

    public void adjustPrefix() {
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "radius", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "extra", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
            new extraType(tmpNode).adjustPrefix();
        }
    }

    public static int getradiusMinCount() {
        return 1;
    }

    public static int getradiusMaxCount() {
        return 1;
    }

    public int getradiusCount() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius");
    }

    public boolean hasradius() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius");
    }

    public float2 newradius() {
        return new float2();
    }

    public float2 getradiusAt(int index) throws Exception {
        return new float2(
                getDomNodeValue(dereference(getDomChildAt(Element,
                        "http://www.collada.org/2005/11/COLLADASchema",
                        "radius", index))));
    }

    public org.w3c.dom.Node getStartingradiusCursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius");
    }

    public org.w3c.dom.Node getAdvancedradiusCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius",
                curNode);
    }

    public float2 getradiusValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new float2(getDomNodeValue(dereference(curNode)));
    }

    public float2 getradius() throws Exception {
        return getradiusAt(0);
    }

    public void removeradiusAt(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius", index);
    }

    public void removeradius() {
        while (hasradius())
            removeradiusAt(0);
    }

    public void addradius(float2 value) {
        if (value.isNull() == false) {
            appendDomChild(Element,
                    "http://www.collada.org/2005/11/COLLADASchema", "radius",
                    value.toString());
        }
    }

    public void addradius(String value) throws Exception {
        addradius(new float2(value));
    }

    public void insertradiusAt(float2 value, int index) {
        insertDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius",
                index, value.toString());
    }

    public void insertradiusAt(String value, int index) throws Exception {
        insertradiusAt(new float2(value), index);
    }

    public void replaceradiusAt(float2 value, int index) {
        replaceDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "radius",
                index, value.toString());
    }

    public void replaceradiusAt(String value, int index) throws Exception {
        replaceradiusAt(new float2(value), index);
    }

    public static int getextraMinCount() {
        return 0;
    }

    public static int getextraMaxCount() {
        return Integer.MAX_VALUE;
    }

    public int getextraCount() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra");
    }

    public boolean hasextra() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra");
    }

    public extraType newextra() {
        return new extraType(domNode.getOwnerDocument().createElementNS(
                "http://www.collada.org/2005/11/COLLADASchema", "extra"));
    }

    public extraType getextraAt(int index) throws Exception {
        return new extraType(
                dereference(getDomChildAt(Element,
                        "http://www.collada.org/2005/11/COLLADASchema",
                        "extra", index)));
    }

    public org.w3c.dom.Node getStartingextraCursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra");
    }

    public org.w3c.dom.Node getAdvancedextraCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra",
                curNode);
    }

    public extraType getextraValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new extraType(dereference(curNode));
    }

    public extraType getextra() throws Exception {
        return getextraAt(0);
    }

    public void removeextraAt(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "extra", index);
    }

    public void removeextra() {
        while (hasextra())
            removeextraAt(0);
    }

    public void addextra(extraType value) {
        appendDomElement("http://www.collada.org/2005/11/COLLADASchema",
                "extra", value);
    }

    public void insertextraAt(extraType value, int index) {
        insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "extra", index, value);
    }

    public void replaceextraAt(extraType value, int index) {
        replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "extra", index, value);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
