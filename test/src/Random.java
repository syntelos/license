
/**
 * Write random output
 */
public class Random {

    public static void main(String[] argv){
        final license.Key key = new license.Key().create(1024);

        System.out.printf("Key: %s%n",key);

        final license.Nonce nonce = new license.Nonce().create(1024);

        System.out.printf("Nonce: %s%n",nonce);

        final license.Function function = new license.Function();
        function.setName("SHA-1");

        System.out.printf("Function: %s%n",function);

        if (function.xor(key,nonce)){

            license.Hash hash = function.digest(license.Hash.class);

            System.out.printf("Hash: %s%n",hash);
            System.exit(0);
        }
        else
            System.exit(1);
    }
}

