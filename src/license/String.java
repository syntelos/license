/*
 * Simple Lossy License (http://github.com/syntelos/license)
 * Copyright (C) 2012, John Pritchard
 * 
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package license;

/**
 * Mutable protocol member
 * 
 * @see Key
 * @see License
 * @see Nonce
 */
public class String
    extends java.lang.Number
{

    private java.math.BigInteger string;


    public String(java.lang.String string){
        super();
        this.setString(string);
    }
    public String(byte[] string){
        super();
        this.setString(string);
    }
    public String(){
        super();
    }


    public int intValue(){
        if (null != this.string)
            return this.string.intValue();
        else
            return 0;
    }
    public long longValue(){
        if (null != this.string)
            return this.string.longValue();
        else
            return 0;
    }
    public float floatValue(){
        if (null != this.string)
            return this.string.floatValue();
        else
            return 0;
    }
    public double doubleValue(){
        if (null != this.string)
            return this.string.doubleValue();
        else
            return 0;
    }
    public boolean hasString(){
        return (null != this.string);
    }
    public java.lang.String getString(int radix){
        if (null != this.string)
            return this.string.toString(radix);
        else
            return "";
    }
    public byte[] getValue(){
        if (null != this.string)
            return this.string.toByteArray();
        else
            return new byte[0];
    }
    public java.lang.String getString(){
        return this.getString(16);
    }
    public boolean setString(byte[] string){
        if (null != string && 0 < string.length){
            try {
                this.string = new java.math.BigInteger(string);
                return true;
            }
            catch (RuntimeException empty){

            }
        }
        return false;
    }
    public boolean setString(java.lang.String string){
        return this.setString(string,16);
    }
    public boolean setString(java.lang.String string, int radix){
        if (null != string && 0 < string.length()){
            try {
                this.string = new java.math.BigInteger(string,radix);
                return true;
            }
            catch (RuntimeException empty){

            }
        }
        return false;
    }
    public int hashCode(){
        return this.toString().hashCode();
    }
    public java.lang.String toString(){
        return this.getString();
    }
}
