package org.suggs.sandbox.algorithms.socialgraph;

import org.junit.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.suggs.sandbox.algorithms.socialgraph.GraphTrawler.forGraph;
import static org.suggs.sandbox.algorithms.socialgraph.SocialGraphMemberBuilder.aSocialGraphMemberWithANameOf;

public class SocialGraphTest {

    @Test
    public void listsNamesOfFriendsForASingleLayeredGraph() {
        Member member = createSimpleSocialGraph();
        assertThat(forGraph(member).allFriends().collect(Collectors.toList())).hasSize(2).contains("Allen", "Bob");
    }

    @Test
    public void calculatesLevelOfFoundFriendForLevelOneFriends() {
        Member graph = createSimpleSocialGraph();
        assertThat(forGraph(graph).findFriendDepth("Allen")).isEqualTo(1);
    }

    @Test
    public void calculatesLevelOfFoundFriendForLevelTwoFriends() {
        Member graph = createSimpleSocialGraph();
        assertThat(forGraph(graph).findFriendDepth("Simon")).isEqualTo(2);
    }

    @Test(expected = FriendNotFoundException.class)
    public void throwsExceptionWhenFriendNotFound() {
        Member graph = createSimpleSocialGraph();
        forGraph(graph).findFriendDepth("FooBar");
    }

    @Test(expected = FriendNotFoundException.class)
    public void ignoresDuplicateGraphMembers() {
        Member graph = createCyclicalSocialGraph();
        forGraph(graph).findFriendDepth("FooBar");
    }

    private Member createSimpleSocialGraph() {
        Member simon = aSocialGraphMemberWithANameOf("Simon").build();
        Member bob = aSocialGraphMemberWithANameOf("Bob").withFriends(simon).build();
        Member allen = aSocialGraphMemberWithANameOf("Allen").withFriends(simon).build();
        return aSocialGraphMemberWithANameOf("Pete")
                .withFriends(allen, bob)
                .build();
    }

    private Member createCyclicalSocialGraph() {
        Member feefee = aSocialGraphMemberWithANameOf("Feefee").build();
        Member foofoo = aSocialGraphMemberWithANameOf("Foofoo").build();
        feefee.addFriends(foofoo);
        foofoo.addFriends(feefee);
        return aSocialGraphMemberWithANameOf("foofee").withFriends(feefee, foofoo).build();
    }


}
