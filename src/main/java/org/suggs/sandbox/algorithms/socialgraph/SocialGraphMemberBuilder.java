package org.suggs.sandbox.algorithms.socialgraph;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class SocialGraphMemberBuilder {

    private String name;
    private List<Member> friends = new ArrayList<Member>();

    private SocialGraphMemberBuilder(String aName) {
        name = aName;
    }

    public static SocialGraphMemberBuilder aSocialGraphMemberWithANameOf(String aName) {
        return new SocialGraphMemberBuilder(aName);
    }

    public SocialGraphMemberBuilder withFriends(Member... someFriends) {
        friends.addAll(asList(someFriends));
        return this;
    }

    public Member build() {
        Member member = new Member(name);
        member.addFriends(friends);
        return member;
    }
}
