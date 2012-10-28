
/**
 * Write random output
 */
public class StringIO {

    public static void main(String[] argv){
        license.Key key = new license.Key().create(1024);

        System.out.printf("Key: %s%n",key);

        license.Nonce nonce = new license.Nonce().create(1024);

        System.out.printf("Nonce: %s%n",nonce);

        final license.Function function = new license.Function();
        function.setName("SHA-1");

        System.out.printf("Function: %s%n",function);

        if (function.xor(key,nonce)){

            license.Hash hash1 = function.digest(license.Hash.class);

            System.out.printf("Hash-1: %s%n",hash1);


            function.clear();

            key = new license.Key(key.toString());
            nonce = new license.Nonce(nonce.toString());

            if (function.xor(key,nonce)){

                license.Hash hash2 = function.digest(license.Hash.class);

                System.out.printf("Hash-2: %s%n",hash2);

                if (hash1.equals(hash2))
                    System.exit(0);
                else
                    System.exit(1);
            }
            else
                System.exit(1);
        }
        else
            System.exit(1);
    }
}

