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

import java.security.SecureRandom;
import java.util.Random;

/**
 * 
 */
public class Prng
    extends java.lang.Number
{
    public final static java.lang.String Default = "SHA";


    protected int hashCode;


    public Prng(){
        super();
    }


    public final Random createPrng(int nbits){

        return this.createPrng(Default,nbits);
    }
    public final Random createPrng(java.lang.String name, int nbits){
        Random prng = null;

        if (null != name){

            try {
                prng = SecureRandom.getInstance(name);
            }
            catch (Exception exc1){

                try {
                    prng = SecureRandom.getInstance(Default);
                }
                catch (Exception exc2){

                    prng = new Random();
                }
            }
        }
        else {
            prng = new Random();
        }

        //prng.generateSeed(nbits);//to generate 1024 bits, linux goes to native prng and hangs 
        prng.setSeed(System.nanoTime());
        return prng;
    }
    public int intValue(){
        return this.hashCode;
    }
    public long longValue(){
        return (long)this.hashCode;
    }
    public float floatValue(){
        return (float)this.hashCode;
    }
    public double doubleValue(){
        return (double)this.hashCode;
    }
    public int hashCode(){
        return this.hashCode;
    }

}
