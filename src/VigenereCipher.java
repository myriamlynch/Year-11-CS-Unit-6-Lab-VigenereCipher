public class VigenereCipher {

    private String key;
    private String alphabet;

    public VigenereCipher(String k)
    {
        key = k.toLowerCase();
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public String getKey()
    {
        return key;
    }
    public String getAlphabet()
    {
        return alphabet;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String encode(String str)
    {
        String newKey = "";
        String coded = "";
        while(newKey.length() < str.length())
        {
            newKey += key;
        }
        while(newKey.length() > str.length())
        {
            newKey = newKey.substring(0, newKey.length() - 1);
        }
        for(int i = 0; i < str.length(); i++)
        {
            if(alphabet.indexOf(str.charAt(i)) > -1)
            {
                int keyInd = alphabet.indexOf(newKey.charAt(i));
                int strInd = alphabet.indexOf(str.charAt(i));
                String newChar = String.valueOf(alphabet.charAt(keyInd+strInd));
                coded += newChar;
            }
            else
                coded += str.charAt(i);
        }
        coded = coded.toLowerCase();
        return coded;
    }

    public String decode(String str)
    {
        String newKey = "";
        String decoded = "";
        while(newKey.length() < str.length())
        {
            newKey += key;
        }
        while(newKey.length() > str.length())
        {
            newKey = newKey.substring(0, newKey.length() - 1);
        }

        for(int i = 0; i <str.length(); i++)
        {
            if(alphabet.indexOf(str.charAt(i)) > -1)
            {
                int keyInd = alphabet.indexOf(newKey.charAt(i));
                int strInd = alphabet.indexOf(str.charAt(i));
                int newInd = strInd-keyInd;
                if(newInd < 0)
                    newInd += 26;
                String newChar = String.valueOf(alphabet.charAt(newInd));
                decoded += newChar;
            }
            else
                decoded += str.charAt(i);
        }
        decoded = decoded.toLowerCase();
        return decoded;
    }
}
