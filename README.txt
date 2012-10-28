
Simple lossy license protocol


  Overview


    Common base classes in Java for license sharing.

    A license access right is recognized by a network server on behalf
    of an attached client.

    The solution set is characterized* for open review.


  Classes


    license.{License,Key,Nonce,Hash}

      Mutable bit strings with string formatted I/O


    license.json.{License,Key,Nonce,Hash}

      Mutable bit strings with JSON formatted I/O


    license.Function

      Configurable hash function

        license.Key key;
        license.Nonce nonce;

        license.Function function = new license.Function();

        if (function.xor(key,nonce)){

          license.Hash hash = function.digest(license.Hash.class);
        }


 * See PROTOCOL.txt


