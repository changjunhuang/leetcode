package interview.huawei;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangchangjun
 * @date
 */
public class SimulationTest2 {

    public static void main(String[] args) {
        String version1 = "1.5.1-A";
        String version2 = "1.5.1-a";

        System.out.println(mvnVersion(version1, version2));
    }

    public static String mvnVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return version1 == null ? version1 : version2;
        }

        //  版本1
        int preIndex = version1.indexOf("-");
        if (preIndex < 0) {
            preIndex = version1.length() - 1;
        }
        String preTemp = version1.substring(0, preIndex);
        List<String> prelist = Arrays.asList(preTemp.split("\\."));
        String preMilestone = version1.substring(preIndex + 1);

        //  版本2
        int afterIndex = version2.indexOf("-");
        if (afterIndex < 0) {
            afterIndex = version2.length() - 1;
        }
        String afterTemp = version2.substring(0, afterIndex);
        List<String> afterlist = Arrays.asList(afterTemp.split("\\."));
        String afterMilestone = version2.substring(afterIndex + 1);

        //  比较 <主版本>.<次版本>.<增量版本>
        for (int i = 0; i < Math.max(prelist.size(), afterlist.size()); i++) {
            if (prelist.size() >= i + 1 && afterlist.size() >= i + 1) {
                int ver1 = Integer.parseInt(prelist.get(i));
                int ver2 = Integer.parseInt(afterlist.get(i));

                if (ver1 == ver2) {
                    continue;
                }
                return ver1 >= ver2 ? version1 : version2;
            } else {
                if (prelist.size() < i + 1) {
                    return version2;
                }
                if (afterlist.size() < i + 1) {
                    return version1;
                }
            }
        }

        //  比较 <里程碑版本>
        return preMilestone.compareTo(afterMilestone) > 0 ? version1 : version2;
    }
}
