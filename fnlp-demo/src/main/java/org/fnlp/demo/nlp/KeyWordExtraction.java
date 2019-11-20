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

import org.fnlp.app.keyword.AbstractExtractor;
import org.fnlp.app.keyword.WordExtract;
import org.fnlp.nlp.cn.tag.CWSTagger;
import org.fnlp.nlp.corpus.StopWords;

/**
 * 关键词抽取使用示例
 * @author jyzhao, ltian
 *
 */
public class KeyWordExtraction {

    public static void main(String[] args) throws Exception {


        StopWords sw = new StopWords("./models/stopwords");
        CWSTagger seg = new CWSTagger("./models/seg.m");
        AbstractExtractor key = new WordExtract(seg, sw);

        System.out.println(key.extract("甬温线特别重大铁路交通事故车辆经过近24小时的清理工作，26日深夜已经全部移出事故现场，之前埋下的D301次动车车头被挖出运走", 20, true));
        System.out.println(key.extract("2019年10月10号凌晨2点半，涟水交警接警后，发现现场除了受害者李梅，身份证号500102198802012212，电话18600213245，固定电话02387898765，家住：建胜镇龙桥花苑小区2栋7-3的血迹、一块机动车号牌苏A F001U和苏AF001U少量玻璃碎片外，没有其他有价值的线索。令人悲痛的是，伤者也因伤势过重经抢救无效身亡。"
            , 20, true));

        //处理已经分好词的句子
        sw = null;
        key = new WordExtract(seg, sw);
        System.out.println(key.extract("甬温线 特别 重大 铁路交通事故车辆经过近24小时的清理工作，26日深夜已经全部移出事故现场，之前埋下的D301次动车车头被挖出运走", 20));
        System.out.println(key.extract("赵嘉亿 是 好人 还是 坏人", 5));

        key = new WordExtract();
        System.out.println(key.extract("", 5));


    }
}