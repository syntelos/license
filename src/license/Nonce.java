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

public class Nonce
    extends license.String
{
    public final static int DefaultRadix = Key.DefaultRadix;


    public Nonce(int radix, byte[] value){
        super(radix,value);
    }
    public Nonce(int radix, java.lang.String value){
        super(radix,value);
    }
    public Nonce(int radix){
        super(radix);
    }
    public Nonce(byte[] value){
        super(DefaultRadix,value);
    }
    public Nonce(java.lang.String value){
        super(DefaultRadix,value);
    }
    public Nonce(){
        super(DefaultRadix);
    }
}
