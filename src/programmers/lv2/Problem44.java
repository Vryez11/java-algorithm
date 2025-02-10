package src.programmers.lv2;

import java.util.Arrays;

public class Problem44 {

    // 스킬트리
    public int solution(String skill, String[] skill_trees) {

        String[] skills = skill.split("");
        int[] indexes;
        int count = 0;

        for (String skillTree : skill_trees) {
            indexes = new int[skills.length];
            for (int i = 0; i < skills.length; i++) {
                indexes[i] = skillTree.indexOf(skills[i]);
            }
            if (isValidSkillTree(indexes)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidSkillTree(int[] indexes) {
        boolean flag = false;

        for (int i = 0; i < indexes.length - 1; i++) {
            if (flag) {
                if (indexes[i] != -1 || indexes[i + 1] != -1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (indexes[i] == -1) {
                flag = true;
                if (indexes[i+1] != - 1) return false;
                continue;
            }
            if (indexes[i] > indexes[i + 1] && indexes[i+1] != -1) return false;
        }
        return true;
    }
}