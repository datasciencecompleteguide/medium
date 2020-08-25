public class SearchDict_charArray { 
    static final int SIZE = 26; 

    static class TrieNode 
    { 
        TrieNode[] Child = new TrieNode[SIZE]; 

        boolean leaf; 

        public TrieNode() { 
            leaf = false; 
            for (int i =0 ; i< SIZE ; i++) 
                    Child[i] = null; 
        } 
    } 

    static void insert(TrieNode root, String Key) 
    { 
        int n = Key.length(); 
        TrieNode pChild = root; 
       
        for (int i=0; i<n; i++) 
        { 
            int index = Key.charAt(i) - 'a'; 
       
            if (pChild.Child[index] == null) 
                pChild.Child[index] = new TrieNode(); 
       
            pChild = pChild.Child[index]; 
        } 

        pChild.leaf = true; 
    } 

    static void searchWord(TrieNode root, boolean Hash[], 
                                            String str) 
    { 
 
        if (root.leaf == true) 
            System.out.println(str); 

        for (int K =0; K < SIZE; K++) 
        { 
            if (Hash[K] == true && root.Child[K] != null ) 
            { 
                char c = (char) (K + 'a'); 

                searchWord(root.Child[K], Hash, str + c); 
            } 
        } 
    } 

    static void PrintAllWords(char Arr[], TrieNode root,  
                                              int n) 
    { 

        boolean[] Hash = new boolean[SIZE]; 
       
        for (int i = 0 ; i < n; i++) 
            Hash[Arr[i] - 'a'] = true; 

        TrieNode pChild = root ; 

        String str = ""; 
        for (int i = 0 ; i < SIZE ; i++) 
        { 
            if (Hash[i] == true && pChild.Child[i] != null ) 
            { 
                str = str+(char)(i + 'a'); 
                searchWord(pChild.Child[i], Hash, str); 
                str = ""; 
            } 
        } 
    } 
    public static void main(String args[]) 
    {  
        String Dict[] = {"go", "bat", "me", "eat", 
                           "goal", "boy", "run"} ; 
        TrieNode root = new TrieNode(); 
        int n = Dict.length; 
        for (int i=0; i<n; i++) 
            insert(root, Dict[i]); 
       
        char arr[] = {'e', 'o', 'b', 'a', 'm', 'g', 'l'} ; 
        int N = arr.length; 
       
        PrintAllWords(arr, root, N); 
    } 
}