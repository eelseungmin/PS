import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int n;
    static ArrayList<ArrayList<Character>> adj;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char par = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            adj.get(par - 'A').add(left);
            adj.get(par - 'A').add(right);
        }

        preOrder('A');
        sb.append('\n');
        inOrder('A');
        sb.append('\n');
        postOrder('A');
        sb.append('\n');

        System.out.println(sb);
    }


    private static void preOrder(char root) {
        if (root == '.') {
            return;
        }

        sb.append(root);
        preOrder(adj.get(root - 'A').get(0));
        preOrder(adj.get(root - 'A').get(1));
    }

    private static void inOrder(char root) {
        if (root == '.') {
            return;
        }

        inOrder(adj.get(root - 'A').get(0));
        sb.append(root);
        inOrder(adj.get(root - 'A').get(1));
    }

    private static void postOrder(char root) {
        if (root == '.') {
            return;
        }

        postOrder(adj.get(root - 'A').get(0));
        postOrder(adj.get(root - 'A').get(1));
        sb.append(root);
    }
}