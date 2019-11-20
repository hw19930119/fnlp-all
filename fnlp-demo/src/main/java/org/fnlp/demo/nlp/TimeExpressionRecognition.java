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

/**
 *  时间表达式识别实例
 *
 * @author 曹零 07300720158
 *
 */
public class TimeExpressionRecognition {
    public static void main(String[] args) {
        String target = "08年北京申办奥运会，8月8号开幕式，九月十八号闭幕式。" +
            "1年后的7月21号发生了件大事。" +
            "今天我本想去世博会，但是人太多了，直到晚上9点人还是那么多。" +
            "考虑到明天和后天人还是那么多，决定下周日再去。";
        String str1 = "2019年10月10号凌晨2点半，涟水交警接警后，发现现场除了受害者李梅，身份证号500102198802012212，电话18600213245，固定电话02387898765，家住：建胜镇龙桥花苑小区2栋7-3的血迹、一块机动车号牌苏A F001U和苏AF001U少量玻璃碎片外，没有其他有价值的线索。令人悲痛的是，第二天上午10点，伤者也因伤势过重经抢救无效身亡。。";

        TimeNormalizer normalizer;
        normalizer = new TimeNormalizer("./models/time.m");
        normalizer.parse(str1);
        TimeUnit[] unit = normalizer.getTimeUnit();
        for (int i = 0; i < unit.length; i++) {
            System.out.println(unit[i]);
        }
    }
}