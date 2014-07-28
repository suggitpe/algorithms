package org.suggs.sandbox.algorithms.socialgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphTrawler {

    private final Member graph;
    private final Collection<Member> visitedMembers = new ArrayList<Member>();

    private GraphTrawler(Member aGraph) {
        graph = aGraph;
    }

    public static GraphTrawler forGraph(Member aGraph) {
        return new GraphTrawler(aGraph);
    }

    public Stream<String> allFriends() {
        return graph.getFriends().map(member -> member.getName());
    }

    public int findFriendDepth(String aName) {
        return findFriendDepthFromCollectionOfMembers(Arrays.asList(graph), aName, 0);
    }

    private int findFriendDepthFromCollectionOfMembers(Collection<Member> allMembersForLevel, String aName, int level) {
        if (allMembersForLevel.isEmpty()) {
            throw new FriendNotFoundException("Could not find a friend called " + aName);
        }

        if (memberExistsAtThisLevel(allMembersForLevel, aName)) {
            return level;
        }

        Collection<Member> nextLevelOfMembers = allMembersForLevel.stream()
                .filter(member -> !visitedMembers.contains(member))
                .peek(member -> visitedMembers.add(member))
                .flatMap(member -> member.getFriends())
                .collect(Collectors.toList());

        return findFriendDepthFromCollectionOfMembers(nextLevelOfMembers, aName, ++level);
    }

    private boolean memberExistsAtThisLevel(Collection<Member> allMembersForLevel, String aName) {
        return allMembersForLevel.stream().filter(member -> member.getName().equals(aName)).count() > 0;
    }
}
