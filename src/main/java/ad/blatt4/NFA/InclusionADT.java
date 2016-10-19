package ad.blatt4.NFA;



import java.util.Collection;

/**
 * Created by Neak on 19.10.2016.
 * Abstract Data Type NFA inclusion
 */
abstract class InclusionADT {

    // ================== ADT-Methods ============================

    /**
     * Runtime: O(n²)
     * @require nfa_p not empty
     * @require nfa_p not empty
     * @param nfa_p NFA that produces sequences
     * @param nfa_s NFA that specifies allowed sequences
     * @return true if the producing NFA includes the sequence of the specifying NFA.
     */

    public Boolean SeqIncludesADT(Collection<?> nfa_p, Collection<?> nfa_s) {
        // Precondition
        assert nfa_p.isEmpty() : "nfa_p is empty";
        assert nfa_s.isEmpty() : "nfa_s empty";
        assert nfa_p.getClass().equals(nfa_s.getClass()) : "different types are not allowed";
        // Implementation
        Boolean aBoolean = SeqIncludes(nfa_p, nfa_s);
        return aBoolean;
    }

    // ================== For implementation ============================

    Boolean SeqIncludes(Collection<?> nfa0, Collection<?> nfa1) {
        return null;
    }


}
