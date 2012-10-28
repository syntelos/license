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

import java.lang.reflect.Constructor;

import java.security.MessageDigest;
import java.util.Random;

/**
 * The name of this function references an available {@link
 * java.security.MessageDigest MessageDigest} hash function, for
 * example "SHA-1".  
 * 
 * <p> The name is the identity of an instance of this class, and the
 * primary state of an instance of this class.  It may be set and
 * reset. </p>
 * 
 * <p> The secondary state of an instance of this class is the
 * internal state of the hash function.  It may be defined, disgested,
 * and reset.  A change to the function name discards the state of the
 * hash function. </p>
 */
public class Function
    extends Prng
{
    public final static java.lang.String Default = "SHA-1";


    private java.lang.String name;

    private MessageDigest function;


    public Function(java.lang.String name){
        super();
        this.setName(name);
    }
    public Function(){
        super();
    }


    public void clear() {
        if (null != this.function)
            this.function.reset();
    }
    public boolean cat(license.String a) {
        if (null != a && null != this.function){

            this.function.update(a.getValue());
            return true;
        }
        return false;
    }
    public boolean xor(license.String a, license.String b) {
        if (null != a && null != b && null != this.function){
            final byte[] av = a.getValue();
            final byte[] bv = b.getValue();
            final int alen = av.length;
            final int blen = bv.length;
            final int len = java.lang.Math.max(alen,blen);

            final byte[] iv = new byte[len];
            for (int cc = 0; cc < len; cc++){
                if (cc < alen){
                    if (cc < blen)
                        iv[cc] = (byte)((0xFF & av[cc]) ^ (0xFF & bv[cc]));
                    else
                        iv[cc] = av[cc];
                }
                else 
                    iv[cc] = bv[cc];
            }
            this.function.update(iv);
            return true;
        }
        return false;
    }
    public byte[] digest() {
        if (null != this.function)
            return this.function.digest();
        else
            return new byte[0];
    }
    public <S extends license.String> S digest(Class<S> clas) {
        if (null != this.function){
            byte[] ov = this.function.digest();
            try {
                final Constructor<S> ctor = (Constructor<S>)clas.getConstructor(ConstructorArgType);

                return ctor.newInstance(new Object[]{ov});
            }
            catch (Exception exc){
                throw new IllegalArgumentException(clas.getName(),exc);
            }
        }
        else {
            try {
                final Constructor<S> ctor = (Constructor<S>)clas.getConstructor(ConstructorArgType);

                return ctor.newInstance(new Object[]{null});
            }
            catch (Exception exc){
                throw new IllegalArgumentException(clas.getName(),exc);
            }
        }
    }
    /**
     * Define a new random number in a string class.
     */
    public <S extends license.String> S create(Class<S> clas, int nbits){
        final Random prng = this.createPrng(this.name,nbits);
        if (null != prng){
            final byte[] bits = new java.math.BigInteger(nbits,prng).toByteArray();

            try {
                final Constructor<S> ctor = (Constructor<S>)clas.getConstructor(ConstructorArgType);

                return ctor.newInstance(new Object[]{bits});
            }
            catch (Exception exc){
                throw new IllegalArgumentException(clas.getName(),exc);
            }
        }
        else {
            try {
                final Constructor<S> ctor = (Constructor<S>)clas.getConstructor(ConstructorArgType);

                return ctor.newInstance(new Object[]{null});
            }
            catch (Exception exc){
                throw new IllegalArgumentException(clas.getName(),exc);
            }
        }
    }

    public boolean hasName(){
        return (null != name);
    }
    public java.lang.String getName(){
        return this.name;
    }
    public boolean setName(java.lang.String name){
        if (null != name){
            try {
                this.function = MessageDigest.getInstance(name);
                this.name = name;
                this.hashCode = name.hashCode();
            }
            catch (Exception exc){

                //throw new IllegalArgumentException(name);
            }
        }
        return false;
    }
    public boolean equals(java.lang.Object that){
        if (this == that)
            return true;
        else
            return this.toString().equals(that.toString());
    }
    public java.lang.String toString(){
        if (null != this.name)
            return this.name;
        else
            return "";
    }

    private final static Class[] ConstructorArgType = {
        byte[].class
    };
}
