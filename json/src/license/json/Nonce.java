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
package license.json;

import json.Json;
import json.ObjectJson;

/**
 * JSON I/O
 */
public class Nonce
    extends license.Nonce
{
    public Nonce(byte[] value){
        super(value);
    }
    public Nonce(java.lang.String value){
        super(value);
    }
    public Nonce(){
        super();
    }


    public ObjectJson toJson(){
        return this.toJson(new ObjectJson());
    }
    public ObjectJson toJson(ObjectJson thisModel){

        thisModel.setValue("nonce",this.getString());

        return thisModel;
    }
    public boolean fromJson(Json thisModel){
        this.setString( (String)thisModel.getValue("nonce"));
        return true;
    }
}
