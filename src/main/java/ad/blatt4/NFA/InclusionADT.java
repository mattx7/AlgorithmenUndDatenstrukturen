package ad.blatt4.NFA;

/**
 * Created by Neak on 19.10.2016.
 * Abstract Sequence-Elem Inclusion
 */
abstract class InclusionADT<T> {

    // ================== ADT-Methods ============================

    /**
     *
     *  @param elem1 an elem that produces something where you ask yourself if it may be a part or equal to another elem that produces something
     *  @param elem2 this is the elem you think the one mentioned before may be a part of
     *  @return true if elem 1 is included in elem 2
     */
    public Boolean SeqIncludesADT(T elem1, T elem2) {
        return SeqIncludes(elem1, elem2);
    }




    // ================== For implementation ============================

    Boolean SeqIncludes(T elem1, T elem2) {
        return null;
    }




}
