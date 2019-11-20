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


import org.fnlp.ml.types.Dictionary;
import org.fnlp.nlp.cn.tag.CWSTagger;

import java.util.ArrayList;


/**
 * 分词使用示例
 * @author xpqiu
 *
 */
public class ChineseWordSegmentation {
    /**
     * 主程序
     * @param args
     * @throws Exception
     * @throws
     */
    public static void main(String[] args) throws Exception {
        CWSTagger tag = new CWSTagger("./models/seg.m");
        System.out.println("不使用词典的分词：");
        String str = " 媒体计算研究所成立了, 高级数据挖掘(data mining)很难。 乐phone热卖！";
        str = "2019年10月10号凌晨2点半，涟水交警接警后，发现现场除了受害者李梅，身份证号500102198802012212，电话18600213245，固定电话02387898765，家住：建胜镇龙桥花苑小区2栋7-3的血迹、一块机动车号牌苏A F001U和苏AF001U少量玻璃碎片外，没有其他有价值的线索。令人悲痛的是，伤者也因伤势过重经抢救无效身亡。";
        String s = tag.tag(str);
        System.out.println(s);

        //设置英文预处理
        tag.setEnFilter(true);
        s = tag.tag(str);
        System.out.println(s);
//		tag.setEnFilter(false);

        System.out.println("\n设置临时词典：");
        ArrayList<String> al = new ArrayList<String>();
        al.add("数据挖掘");
        al.add("媒体计算研究所");
        al.add("乐phone");
        Dictionary dict = new Dictionary(false);
        dict.addSegDict(al);
        tag.setDictionary(dict);
        s = tag.tag(str);
        System.out.println(s);


        CWSTagger tag2 = new CWSTagger("./models/seg.m", new Dictionary("./models/dict.txt"));
        System.out.println("\n使用词典的分词：");
        String str2 = "媒体计算研究所成立了, 高级数据挖掘很难。 乐phone热卖！";
        String s2 = tag2.tag(str2);
        System.out.println(s2);

        //使用不严格的词典
        CWSTagger tag3 = new CWSTagger("./models/seg.m", new Dictionary("./models/dict_ambiguity.txt", true));
        //尽量满足词典，比如词典中有“成立”“成立了”和“了”, 会使用Viterbi决定更合理的输出
        System.out.println("\n使用不严格的词典的分词：");
        String str3 = "媒体计算研究所成立了, 高级数据挖掘很难";
        String s3 = tag3.tag(str3);
        System.out.println(s3);
        str3 = "我送给力学系的同学一个玩具 (送给给力力学力学系都在词典中)";
        s3 = tag3.tag(str3);
        System.out.println(s3);

        System.out.println("\n处理文件：");
        String s4 = tag.tagFile("./example-data/data-tag.txt");
        System.out.println(s4);

        String s5 = tag2.tagFile("./example-data/data-tag.txt");
        System.out.println(s5);

    }

}