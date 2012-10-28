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

import java.util.Random;

/**
 * Mutable protocol member
 * 
 * @see Key
 * @see License
 * @see Nonce
 */
public class String
    extends Prng
{
    public final static int DefaultRadix = 16;


    private final int radix;

    private java.math.BigInteger number;

    private java.lang.String string;


    public String(int radix, java.lang.String string){
        this(radix);
        this.setString(string);
    }
    public String(int radix, byte[] string){
        this(radix);
        this.setString(string);
    }
    public String(int radix){
        super();
        if (1 < radix)
            this.radix = radix;
        else
            throw new IllegalArgumentException(java.lang.String.valueOf(radix));
    }
    public String(byte[] value){
        this(DefaultRadix,value);
    }
    public String(java.lang.String value){
        this(DefaultRadix,value);
    }
    public String(){
        this(DefaultRadix);
    }


    public int getRadix(){
        return this.radix;
    }
    public int intValue(){
        if (null != this.number)
            return this.number.intValue();
        else
            return 0;
    }
    public long longValue(){
        if (null != this.number)
            return this.number.longValue();
        else
            return 0;
    }
    public float floatValue(){
        if (null != this.number)
            return this.number.floatValue();
        else
            return 0;
    }
    public double doubleValue(){
        if (null != this.number)
            return this.number.doubleValue();
        else
            return 0;
    }
    public byte[] getValue(){
        if (null != this.number)
            return this.number.toByteArray();
        else
            return new byte[0];
    }
    public boolean hasString(){
        return (null != this.number);
    }
    /**
     * @return Number string for radix, or empty string
     */
    public java.lang.String getString(int radix){

        if (null != this.number)

            return this.number.toString(radix);
        else
            return "";
    }
    /**
     * @return Call get string with this radix
     */
    public java.lang.String getString(){

        return this.getString(this.radix);
    }
    public boolean setString(byte[] string){
        if (null != string && 0 < string.length){

            return this.setString(new java.math.BigInteger(string));
        }
        else
            return false;
    }
    public boolean setString(java.lang.String string){
        return this.setString(string,this.radix);
    }
    public boolean setString(java.lang.String string, int radix){
        if (null != string && 0 < string.length()){

            return this.setString(new java.math.BigInteger(string,radix));
        }
        else
            return false;
    }
    public boolean setString(java.math.BigInteger bint){

        if (null != bint){

            this.number = bint;

            this.string = bint.toString(this.radix);

            this.hashCode = bint.hashCode();

            return true;
        }
        else
            return false;
    }
    /**
     * Define this number with a new random number
     */
    public <S extends license.String> S create(int nbits){
        try {
            final Random prng = this.createPrng(nbits);

            this.number = new java.math.BigInteger(nbits,prng);

            this.string = this.number.toString(this.radix);

            this.hashCode = this.number.hashCode();

            return (S)this;
        }
        catch (Exception exc){
            throw new IllegalArgumentException(Function.Default,exc);
        }
    }
    public java.lang.String toString(){
        if (null != this.string)
            return this.string;
        else
            return this.getString();
    }
    public boolean equals(java.lang.Object that){
        if (this == that)
            return true;
        else if (that instanceof license.String)
            return this.equals((license.String)that);
        else if (that instanceof java.math.BigInteger)
            return this.equals((java.math.BigInteger)that);
        else if (that instanceof byte[])
            return this.equals((byte[])that);
        else
            return false;
    }
    public boolean equals(license.String that){
        if (this == that)
            return true;
        else if (null == that)
            return false;
        else
            return this.equals(that.getValue());
    }
    public boolean equals(java.math.BigInteger that){

        if (null == that)
            return false;
        else
            return this.equals(that.toByteArray());
    }
    public boolean equals(byte[] that){
        if (null == this.number)
            return (null == that || 0 == that.length);
        else {
            byte[] thisb = this.number.toByteArray();
            if (thisb.length == that.length){
                final int count = that.length;
                for (int cc = 0; cc < count; cc++){
                    if (thisb[cc] != that[cc])
                        return false;
                }
                return true;
            }
            else
                return false;
        }
    }
}
