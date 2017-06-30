import edu.columbia.cs.psl.phosphor.runtime.Tainter;

import java.io.*;

/**
 * Created by jianyu on 6/24/17.
 */

class TestClass implements Serializable {
    int[] a = new int[3];
}

public class ObjectSerialization {

    static public void main(String[] args) {
        TestClass c = new TestClass();
        ObjectOutputStream s = null;
        try {
            s = new ObjectOutputStream(new FileOutputStream("a.out"));
            s.writeObject(c);
            s.close();
        } catch (IOException e) {

        }

        TestClass[] a = new TestClass[10];

        try {
            TestClass k = (TestClass) new ObjectInputStream(new FileInputStream("a.out")).readObject();

            System.out.println(k.a);
            Tainter.taintedIntArray(k.a, 3);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}