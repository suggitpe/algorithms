package org.suggs.sandbox.algorithms.socialgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Member {

    private final String name;
    private List<Member> friends = new ArrayList<Member>();

    public Member(String aName) {
        name = aName;
    }

    public void addFriends(Member... someFriends) {
        friends.addAll(Arrays.asList(someFriends));
    }

    public String getName() {
        return name;
    }

    public Stream<Member> getFriends() {
        return friends.stream();
    }

    public void addFriends(List<Member> someFriends) {
        friends.addAll(someFriends);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (name != null ? !name.equals(member.name) : member.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
