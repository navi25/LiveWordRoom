package io.navendra.livewordroom.util;

import java.lang.reflect.Field;

/**
 * This class allows any sub class to be converted easily to Json, It's kind of custom replacement of toJson() method
 */
public abstract class Jsonfiable {
    public String toValueString(){
        try {
            StringBuffer sb = new StringBuffer();
            Class objClass = this.getClass();

            Field[] fields = objClass.getDeclaredFields();
            for(int i=0; i<fields.length; i++){
                Field field = fields[i];
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(this)==null? "":field.get(this);
                sb.append(name + ": " + value.toString() + "\n");
            }
            return sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


