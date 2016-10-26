package ad.page5_huffman;

/**
 * Created by MattX7 on 26.10.2016.
 */
class HuffmanLeaf extends HuffmanTree {
    public final char value; // the character this leaf represents

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}
