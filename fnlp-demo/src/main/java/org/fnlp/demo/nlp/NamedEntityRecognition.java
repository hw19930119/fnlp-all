/**
 *  This file is part of FNLP (formerly FudanNLP).
 *
 *  FNLP is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  FNLP is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FudanNLP.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright 2009-2014 www.fnlp.org. All rights reserved.
 */

package org.fnlp.demo.nlp;


import org.fnlp.nlp.cn.ner.TimeNormalizer;
import org.fnlp.nlp.cn.ner.TimeUnit;
import org.fnlp.nlp.cn.tag.NERTagger;

import java.util.HashMap;

/**
 * 实体名识别使用示例
 * @author xpqiu
 *
 */
public class NamedEntityRecognition {


    /**
     * 主程序
     * @param args
     * @throws Exception
     * @throws
     */
    public static void main(String[] args) throws Exception {

        NERTagger tag = new NERTagger("./models/seg.m", "./models/pos.m");
        String str = " 新浪体育讯　北京时间4月15日03:00(英国当地时间14日20:00)，2009/10赛季英格兰足球超级联赛第34轮一场焦点战在白鹿巷球场展开角逐，阿森纳客场1比2不敌托特纳姆热刺，丹尼-罗斯和拜尔先入两球，本特纳扳回一城。阿森纳仍落后切尔西6分(净胜球少15个)，夺冠几成泡影。热刺近 7轮联赛取得6胜，继续以1分之差紧逼曼城。";
        String str1 = "2019年10月10号凌晨2点半，涟水交警接警后，发现现场除了受害者孙小艾，身份证号500102198802012212，电话18600213245，固定电话02387898765，家住：建胜镇龙桥花苑小区2栋7-3的血迹、一块机动车号牌苏A F001U和苏AF001U少量玻璃碎片外，没有其他有价值的线索。令人悲痛的是，第二天上午10点，伤者也因伤势过重经抢救无效身亡。两天前吴子涵还是好好的";
        String str2 = "据了解，2016年业主李梅，身份证号：500102198802012212，电话：18600213245，固定电话：02387898765，家住：建胜镇龙桥花苑小区12栋27-2，陆续入住龙桥花苑小区，随着入住人员增多，一些小商小贩瞄准商机，到此挤占人行道摆摊设点，售卖蔬菜、水果、猪肉等商品，形成“马路市场”，阻碍行人通行，影响了周边环境卫生。“以前，在小区门口的人行道上，曾经同时有30多个小摊贩出摊，不仅造成人行道堵塞，产生的噪声也严重影响居民休息。而且流动摊贩每天产生的大量垃圾，还影响了周边的居住环境。请街道协同区环保局、城管局和执法部门进行整改。";
        HashMap<String, String> map = new HashMap<String, String>();
        tag.tag(str1, map);
        System.out.println("str1=" + map);
        // map = tag.tagFile("./example-data/data-tag.txt");
        // System.out.println(map);

        TimeNormalizer normalizer;
        normalizer = new TimeNormalizer("./models/time.m");
        normalizer.parse(str1);
        TimeUnit[] unit = normalizer.getTimeUnit();
        for (int i = 0; i < unit.length; i++) {
            System.out.println("时间识别：" + unit[i]);
        }
        System.out.println("Done!");
    }
}