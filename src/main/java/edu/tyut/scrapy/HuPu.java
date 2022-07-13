package edu.tyut.scrapy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HuPu {
    /**
     * jsoup方式   获取虎扑新闻列表页
     * @param url 虎扑新闻列表页
     */
    public void jsoupList(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("div > div.list-item-info > a.list-item-title");
        for (Element element : elements) {
            String href = element.attr("href");
            String text = element.text();
            System.out.println("详情页链接："+href+",详情页标题："+text);
        }
    }

    public static void main(String[] args) {
        String url = "https://www.hupu.com/";
        HuPu huPu = new HuPu();
        try {
            huPu.jsoupList(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
详情页链接：https://bbs.hupu.com/54640875.html,详情页标题：【中文字幕】勇士官方出品——夺冠纪录片第一集
详情页链接：https://bbs.hupu.com/54646304.html,详情页标题：[流言板]TA：无人知晓C罗到底会不会去季前赛，但曼联不用交任何赔偿
详情页链接：https://bbs.hupu.com/43692454.html,详情页标题：[战龙无双·翻译]OG阿奴诺比会成为下一个伦纳德
详情页链接：https://bbs.hupu.com/54634075.html,详情页标题：【字幕】格林：做父亲让我学会以身作则，心态上已经不再是次轮秀而是四届冠军
详情页链接：https://bbs.hupu.com/54646270.html,详情页标题：[流言板]张琳艳：遗憾在武汉没和霜姐一起踢过，走出去为了提升自己
详情页链接：https://bbs.hupu.com/54646268.html,详情页标题：[流言板]法足协主席：我和姆巴佩没矛盾，我很尊重他
详情页链接：https://bbs.hupu.com/54646243.html,详情页标题：[流言板]官方：曼联公布新赛季主场球衣，C罗领衔出镜
详情页链接：https://bbs.hupu.com/54529565.html,详情页标题：【原创/洛城谈2】连签四将，紫金军团的方向在何处？
详情页链接：https://bbs.hupu.com/54646211.html,详情页标题：[流言板]TA：曼联阿迪同意不让C罗站C位，同时决定暂不发布特别广告
详情页链接：https://bbs.hupu.com/54645265.html,详情页标题：42岁生日快乐！科比身边最好的二当家！保罗加索尔湖人高光表现
详情页链接：https://bbs.hupu.com/54646019.html,详情页标题：今日份K妹大字报：多数人支持深圳DYG，仅三人看好广州TTG
详情页链接：https://bbs.hupu.com/54645310.html,详情页标题：【字幕】巴恩斯：杜兰特交易难度在于潜在下家既想得到他 又不想放弃太多无法争冠
详情页链接：https://bbs.hupu.com/54646114.html,详情页标题：[流言板]官方：热刺球员贝尔温加盟阿贾克斯
详情页链接：https://bbs.hupu.com/54646112.html,详情页标题：[流言板]官方：39岁西班牙门将雷纳免签回归比利亚雷亚尔，签约一年
详情页链接：https://bbs.hupu.com/54646110.html,详情页标题：[情报站]Chovy：春季赛和夏季赛的GEN不同，我们的团队配合变好了
详情页链接：https://bbs.hupu.com/54645965.html,详情页标题：[流言板]喂饼大师！迪马利亚是自03/04赛季以来欧冠助攻第三多的球员
详情页链接：https://bbs.hupu.com/54634977.html,详情页标题：【字幕】油管船密up：肯纳德是球队文化奠基者 争冠道路上射手不可或缺
详情页链接：https://bbs.hupu.com/54633740.html,详情页标题：【字幕】ESPN：艾顿如果离队会使KD交易生变，霍华德离开魔术与KD情况相似
详情页链接：https://bbs.hupu.com/54645862.html,详情页标题：[流言板]李磊转发张琳艳加盟草蜢的公告，并对其加盟表示欢迎
详情页链接：https://bbs.hupu.com/54643142.html,详情页标题：张镇麟曾凡博等中国球员明日迎来NBA夏联首秀！绽放吧少年！
详情页链接：https://bbs.hupu.com/54645838.html,详情页标题：[流言板]图片报：莱比锡顶薪恩昆库税前800万欧，莱默尔不到400万欧
详情页链接：https://bbs.hupu.com/54645071.html,详情页标题：【字幕】JJ-雷迪克：旧媒体与“舆论导向”有关；必须抵制“厚古薄今”的说法
详情页链接：https://bbs.hupu.com/54636911.html,详情页标题：谢晖的苦恼：大连人再次被禁止引援，球队后劲不足难以解决
详情页链接：https://bbs.hupu.com/54645738.html,详情页标题：[流言板]成都蓉城vs天津津门虎首发：金敃友PK贝里奇，巴顿出战
详情页链接：https://bbs.hupu.com/54645729.html,详情页标题：[流言板]武汉女足祝福张琳艳：在欧洲继续弘扬铿锵玫瑰精神
详情页链接：https://bbs.hupu.com/54645690.html,详情页标题：《LOL街头战士》：KT vs DK的“身体表达 快问快答”大比拼
详情页链接：https://bbs.hupu.com/54644725.html,详情页标题：[话题团]冉冉升起，开拓者的又一杆枪？
详情页链接：https://bbs.hupu.com/54645662.html,详情页标题：[流言板]跟队记者：罗马尼奥利免签加盟拉齐奥，年薪290万签约五年
详情页链接：https://bbs.hupu.com/54643193.html,详情页标题：【雷霆日记】盐湖城夏联：2胜1负，新秀表现令人兴奋，过程远比结果重要！
详情页链接：https://bbs.hupu.com/54641363.html,详情页标题：落后一万四经济翻盘，这可能才是王者荣耀的真正意义吧！
详情页链接：https://bbs.hupu.com/54639696.html,详情页标题：【众生相】曝湖人篮网总经理即将会面！商讨欧文交易，能顺利推进吗？
详情页链接：https://bbs.hupu.com/54644704.html,详情页标题：[话题团]假如你是乌杰里，会放弃未来吗？
详情页链接：https://bbs.hupu.com/54644655.html,详情页标题：[话题团]焦点对决，你怎么看前三顺位的表现？
详情页链接：https://bbs.hupu.com/54645574.html,详情页标题：[流言板]LCK前线探营Ruler：有很多输给T1的回忆，这次一定扼杀下路
详情页链接：https://bbs.hupu.com/54645374.html,详情页标题：广州队青春热血一往无前，上海海港强援归队强势启航！
详情页链接：https://bbs.hupu.com/54645479.html,详情页标题：[流言板]沪媒：国脚接连受伤非偶然，长期连轴转+封闭隔离容易受伤
详情页链接：https://bbs.hupu.com/54633777.html,详情页标题：湾区手铐，活力小子！——小佩顿高燃赛季混剪
详情页链接：https://bbs.hupu.com/54645452.html,详情页标题：[流言板]萨尔：球队会为新赛季做好准备；想为切尔西贡献自己的全部
详情页链接：https://bbs.hupu.com/54644619.html,详情页标题：[话题团]塞宝自由市场遇冷，能否留队实现双赢？
详情页链接：https://bbs.hupu.com/54645445.html,详情页标题：[流言板]LCK前线探营T1.Keria：比起垃圾话，我更尊敬GEN下路组他们
详情页链接：https://bbs.hupu.com/54645434.html,详情页标题：[流言板]官方：巴萨中场佩德里将在新赛季改穿8号球衣
详情页链接：https://bbs.hupu.com/54645337.html,详情页标题：AG官博官宣：六点六以场外的身份正式回归AG
详情页链接：https://bbs.hupu.com/54645405.html,详情页标题：睢冉体验橄榄球运动：拉伤了感谢你们
详情页链接：https://bbs.hupu.com/54645379.html,详情页标题：[流言板]足球小将宣！佛罗伦萨官方发布大空翼漫画，预告约维奇加盟
详情页链接：https://bbs.hupu.com/54644568.html,详情页标题：[话题团]胖又怎样？灰熊是否收获新兰多夫？
详情页链接：https://bbs.hupu.com/54645348.html,详情页标题：[流言板]媒体人：东亚杯应派95-99球员，未来国家队是以他们为主
详情页链接：https://bbs.hupu.com/54645334.html,详情页标题：[流言板]官方：中国女足队员张琳艳租借加盟草蜢女足，为期一年
 */