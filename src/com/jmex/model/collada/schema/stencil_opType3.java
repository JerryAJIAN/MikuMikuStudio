/**
 * stencil_opType3.java This file was generated by XMLSpy 2006sp2 Enterprise
 * Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE OVERWRITTEN WHEN
 * YOU RE-RUN CODE GENERATION. Refer to the XMLSpy Documentation for further
 * details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

public class stencil_opType3 extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public stencil_opType3(stencil_opType3 node) {
        super(node);
    }

    public stencil_opType3(org.w3c.dom.Node node) {
        super(node);
    }

    public stencil_opType3(org.w3c.dom.Document doc) {
        super(doc);
    }

    public stencil_opType3(com.jmex.model.collada.xml.Document doc,
            String namespaceURI, String prefix, String name) {
        super(doc, namespaceURI, prefix, name);
    }

    public void adjustPrefix() {
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "fail"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "fail", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
            new failType4(tmpNode).adjustPrefix();
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zfail"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "zfail", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
            new zfailType4(tmpNode).adjustPrefix();
        }
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zpass"); tmpNode != null; tmpNode = getDomNextChild(
                Element, "http://www.collada.org/2005/11/COLLADASchema",
                "zpass", tmpNode)) {
            internalAdjustPrefix(tmpNode, true);
            new zpassType4(tmpNode).adjustPrefix();
        }
    }

    public static int getfailMinCount() {
        return 1;
    }

    public static int getfailMaxCount() {
        return 1;
    }

    public int getfailCount() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "fail");
    }

    public boolean hasfail() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "fail");
    }

    public failType4 newfail() {
        return new failType4(domNode.getOwnerDocument().createElementNS(
                "http://www.collada.org/2005/11/COLLADASchema", "fail"));
    }

    public failType4 getfailAt(int index) throws Exception {
        return new failType4(dereference(getDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "fail", index)));
    }

    public org.w3c.dom.Node getStartingfailCursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "fail");
    }

    public org.w3c.dom.Node getAdvancedfailCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "fail", curNode);
    }

    public failType4 getfailValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new failType4(dereference(curNode));
    }

    public failType4 getfail() throws Exception {
        return getfailAt(0);
    }

    public void removefailAt(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "fail", index);
    }

    public void removefail() {
        while (hasfail())
            removefailAt(0);
    }

    public void addfail(failType4 value) {
        appendDomElement("http://www.collada.org/2005/11/COLLADASchema",
                "fail", value);
    }

    public void insertfailAt(failType4 value, int index) {
        insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "fail", index, value);
    }

    public void replacefailAt(failType4 value, int index) {
        replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "fail", index, value);
    }

    public static int getzfailMinCount() {
        return 1;
    }

    public static int getzfailMaxCount() {
        return 1;
    }

    public int getzfailCount() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zfail");
    }

    public boolean haszfail() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zfail");
    }

    public zfailType4 newzfail() {
        return new zfailType4(domNode.getOwnerDocument().createElementNS(
                "http://www.collada.org/2005/11/COLLADASchema", "zfail"));
    }

    public zfailType4 getzfailAt(int index) throws Exception {
        return new zfailType4(
                dereference(getDomChildAt(Element,
                        "http://www.collada.org/2005/11/COLLADASchema",
                        "zfail", index)));
    }

    public org.w3c.dom.Node getStartingzfailCursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zfail");
    }

    public org.w3c.dom.Node getAdvancedzfailCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zfail",
                curNode);
    }

    public zfailType4 getzfailValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new zfailType4(dereference(curNode));
    }

    public zfailType4 getzfail() throws Exception {
        return getzfailAt(0);
    }

    public void removezfailAt(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zfail", index);
    }

    public void removezfail() {
        while (haszfail())
            removezfailAt(0);
    }

    public void addzfail(zfailType4 value) {
        appendDomElement("http://www.collada.org/2005/11/COLLADASchema",
                "zfail", value);
    }

    public void insertzfailAt(zfailType4 value, int index) {
        insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "zfail", index, value);
    }

    public void replacezfailAt(zfailType4 value, int index) {
        replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "zfail", index, value);
    }

    public static int getzpassMinCount() {
        return 1;
    }

    public static int getzpassMaxCount() {
        return 1;
    }

    public int getzpassCount() {
        return getDomChildCount(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zpass");
    }

    public boolean haszpass() {
        return hasDomChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zpass");
    }

    public zpassType4 newzpass() {
        return new zpassType4(domNode.getOwnerDocument().createElementNS(
                "http://www.collada.org/2005/11/COLLADASchema", "zpass"));
    }

    public zpassType4 getzpassAt(int index) throws Exception {
        return new zpassType4(
                dereference(getDomChildAt(Element,
                        "http://www.collada.org/2005/11/COLLADASchema",
                        "zpass", index)));
    }

    public org.w3c.dom.Node getStartingzpassCursor() throws Exception {
        return getDomFirstChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zpass");
    }

    public org.w3c.dom.Node getAdvancedzpassCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zpass",
                curNode);
    }

    public zpassType4 getzpassValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new zpassType4(dereference(curNode));
    }

    public zpassType4 getzpass() throws Exception {
        return getzpassAt(0);
    }

    public void removezpassAt(int index) {
        removeDomChildAt(Element,
                "http://www.collada.org/2005/11/COLLADASchema", "zpass", index);
    }

    public void removezpass() {
        while (haszpass())
            removezpassAt(0);
    }

    public void addzpass(zpassType4 value) {
        appendDomElement("http://www.collada.org/2005/11/COLLADASchema",
                "zpass", value);
    }

    public void insertzpassAt(zpassType4 value, int index) {
        insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "zpass", index, value);
    }

    public void replacezpassAt(zpassType4 value, int index) {
        replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema",
                "zpass", index, value);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
