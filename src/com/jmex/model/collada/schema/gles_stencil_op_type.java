/**
 * gles_stencil_op_type.java This file was generated by XMLSpy 2006sp2
 * Enterprise Edition. YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION. Refer to the XMLSpy
 * Documentation for further details. http://www.altova.com/xmlspy
 */

package com.jmex.model.collada.schema;

import com.jmex.model.collada.types.SchemaString;

public class gles_stencil_op_type extends SchemaString {

    private static final long serialVersionUID = 1L;
    public static final int EKEEP = 0; /* KEEP */
    public static final int EZERO = 1; /* ZERO */
    public static final int EREPLACE = 2; /* REPLACE */
    public static final int EINCR = 3; /* INCR */
    public static final int EDECR = 4; /* DECR */
    public static final int EINVERT = 5; /* INVERT */

    public static String[] sEnumValues = { "KEEP", "ZERO", "REPLACE", "INCR",
            "DECR", "INVERT", };

    public gles_stencil_op_type() {
        super();
    }

    public gles_stencil_op_type(String newValue) {
        super(newValue);
        validate();
    }

    public gles_stencil_op_type(SchemaString newValue) {
        super(newValue);
        validate();
    }

    public static int getEnumerationCount() {
        return sEnumValues.length;
    }

    public static String getEnumerationValue(int index) {
        return sEnumValues[index];
    }

    public static boolean isValidEnumerationValue(String val) {
        for (int i = 0; i < sEnumValues.length; i++) {
            if (val.equals(sEnumValues[i]))
                return true;
        }
        return false;
    }

    public void validate() {

        if (!isValidEnumerationValue(toString()))
            throw new com.jmex.model.collada.xml.XmlException(
                    "Value of gles_stencil_op_type is invalid.");
    }
}
