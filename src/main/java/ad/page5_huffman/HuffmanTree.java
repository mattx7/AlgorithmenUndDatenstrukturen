package ad.page5_huffman;

/**
 * Created by MattX7 on 26.10.2016.
 */
abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency; // the frequency of this tree

    public HuffmanTree(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}
