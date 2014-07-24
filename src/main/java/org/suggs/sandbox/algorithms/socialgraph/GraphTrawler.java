package org.suggs.sandbox.algorithms.socialgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphTrawler {

    private final Member graph;
    private final List<Integer> visitedMemberHashes = new ArrayList<Integer>();

    private GraphTrawler(Member aGraph) {
        graph = aGraph;
    }

    public static GraphTrawler forGraph(Member aGraph) {
        return new GraphTrawler(aGraph);
    }

    public List<String> listAllFriends() {
        List<String> friends = new ArrayList<String>();
        for (Member friend : graph.getFriends()) {
            friends.add(friend.getName());
        }
        return friends;
    }

    public int findFriendDepth(String aName) {
        Queue<Member> members = new LinkedBlockingQueue<>();
        members.add(this.graph);
        return findFriendDepthFromQueueOfMembers(members, aName, 0);
    }

    private int findFriendDepthFromQueueOfMembers(Queue<Member> allMembersForLevel, String aName, int level) {
        if (allMembersForLevel.isEmpty()) {
            throw new FriendNotFoundException("Could not find a friend called " + aName);
        }
        Queue<Member> nextLevelOfMembers = new LinkedBlockingQueue<>();
        while (!allMembersForLevel.isEmpty()) {
            Member member = allMembersForLevel.remove();
            if (member.getName().equals(aName)) {
                return level;
            }
            visitedMemberHashes.add(member.hashCode());
            for (Member friendOfMember : member.getFriends()) {
                if (weHaveNotCheckedMemberBefore(friendOfMember)) {
                    nextLevelOfMembers.add(friendOfMember);
                }
            }
        }
        return findFriendDepthFromQueueOfMembers(nextLevelOfMembers, aName, ++level);
    }

    private boolean weHaveNotCheckedMemberBefore(Member friendOfFriends) {
        return !visitedMemberHashes.contains(friendOfFriends.hashCode());
    }


}
