package ai.timefold.solver.core.impl.heuristic.selector.move.generic.list.kopt;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Describes the minimal amount of cycles a permutation can be expressed as
 * and provide a mapping of removed edge endpoint index to cycle identifier
 * (where all indices that are in the same k-cycle have the same identifier).
 *
 * @param cycleCount The total number of k-cycles in the permutation.
 *        This is one more than the maximal value in {@link KOptCycle#indexToCycleIdentifier}.
 * @param indexToCycleIdentifier Maps an index in the removed endpoints to the cycle it belongs to
 *        after the new edges are added.
 *        Ranges from 0 to {@link #cycleCount} - 1.
 */
record KOptCycle(int cycleCount, int[] indexToCycleIdentifier) {

    @Override
    public String toString() {
        String arrayString = IntStream.of(indexToCycleIdentifier)
                .sequential()
                .skip(1)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        return "KOptCycleInfo(" +
                "cycleCount=" + cycleCount +
                ", indexToCycleIdentifier=" + arrayString +
                ')';
    }

}
