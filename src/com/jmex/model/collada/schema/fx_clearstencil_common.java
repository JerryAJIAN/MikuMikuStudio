/**
 * fx_clearstencil_common.java This file was generated by XMLSpy 2006sp2
 * Enterprise Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION. Refer to the XMLSpy
 * Documentation for further details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

import com.jmex.model.collada.types.SchemaByte;
import com.jmex.model.collada.types.SchemaInteger;
import com.jmex.model.collada.types.SchemaType;

public class fx_clearstencil_common extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

    public fx_clearstencil_common(fx_clearstencil_common node) {
        super(node);
    }

    public fx_clearstencil_common(org.w3c.dom.Node node) {
        super(node);
    }

    public fx_clearstencil_common(org.w3c.dom.Document doc) {
        super(doc);
    }

    public fx_clearstencil_common(com.jmex.model.collada.xml.Document doc,
            String namespaceURI, String prefix, String name) {
        super(doc, namespaceURI, prefix, name);
    }

    public SchemaByte getValue() {
        return new SchemaByte(getDomNodeValue(dereference(domNode)));
    }

    public void setValue(SchemaType value) {
        setDomNodeValue(domNode, value.toString());
    }

    public void assign(SchemaType value) {
        setValue(value);
    }

    public void adjustPrefix() {
        for (org.w3c.dom.Node tmpNode = getDomFirstChild(Attribute, null,
                "index"); tmpNode != null; tmpNode = getDomNextChild(Attribute,
                null, "index", tmpNode)) {
            internalAdjustPrefix(tmpNode, false);
        }
    }

    public static int getindexMinCount() {
        return 0;
    }

    public static int getindexMaxCount() {
        return 1;
    }

    public int getindexCount() {
        return getDomChildCount(Attribute, null, "index");
    }

    public boolean hasindex() {
        return hasDomChild(Attribute, null, "index");
    }

    public SchemaInteger newindex() {
        return new SchemaInteger();
    }

    public SchemaInteger getindexAt(int index) throws Exception {
        return new SchemaInteger(getDomNodeValue(dereference(getDomChildAt(
                Attribute, null, "index", index))));
    }

    public org.w3c.dom.Node getStartingindexCursor() throws Exception {
        return getDomFirstChild(Attribute, null, "index");
    }

    public org.w3c.dom.Node getAdvancedindexCursor(org.w3c.dom.Node curNode)
            throws Exception {
        return getDomNextChild(Attribute, null, "index", curNode);
    }

    public SchemaInteger getindexValueAtCursor(org.w3c.dom.Node curNode)
            throws Exception {
        if (curNode == null)
            throw new com.jmex.model.collada.xml.XmlException("Out of range");
        else
            return new SchemaInteger(getDomNodeValue(dereference(curNode)));
    }

    public SchemaInteger getindex() throws Exception {
        return getindexAt(0);
    }

    public void removeindexAt(int index) {
        removeDomChildAt(Attribute, null, "index", index);
    }

    public void removeindex() {
        while (hasindex())
            removeindexAt(0);
    }

    public void addindex(SchemaInteger value) {
        if (value.isNull() == false) {
            appendDomChild(Attribute, null, "index", value.toString());
        }
    }

    public void addindex(String value) throws Exception {
        addindex(new SchemaInteger(value));
    }

    public void insertindexAt(SchemaInteger value, int index) {
        insertDomChildAt(Attribute, null, "index", index, value.toString());
    }

    public void insertindexAt(String value, int index) throws Exception {
        insertindexAt(new SchemaInteger(value), index);
    }

    public void replaceindexAt(SchemaInteger value, int index) {
        replaceDomChildAt(Attribute, null, "index", index, value.toString());
    }

    public void replaceindexAt(String value, int index) throws Exception {
        replaceindexAt(new SchemaInteger(value), index);
    }

    private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
        return node;
    }
}
