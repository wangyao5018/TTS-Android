package com.wyjson.tts;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextToSpeech tts;
    private TextView tvTitle;

    private List<String> topic = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tv_title);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                Log.e("status", status + "");
                if (status == TextToSpeech.SUCCESS) {
                    // 设置播放语言
                    int result = tts.setLanguage(Locale.CHINESE);
//                    tts.setPitch(1.8f);
//                    tts.setSpeechRate(1.5f);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        tvTitle.setText("不支持");
                        Toast.makeText(MainActivity.this, "不支持", Toast.LENGTH_SHORT).show();
                    } else if (result == TextToSpeech.LANG_AVAILABLE) {
                        //初始化成功之后才可以播放文字
                        //否则会提示“speak failed: not bound to tts engine
                        //TextToSpeech.QUEUE_ADD 会将加入队列的待播报文字按顺序播放
                        //TextToSpeech.QUEUE_FLUSH 会替换原有文字
                    }
                } else {
                    tvTitle.setText("初始化失败");
                    Log.e("TAG", "初始化失败");
                }
            }
        });

        addTopic();

    }

    private void addTopic() {
        topic.add("备号称皇叔，问他是谁的子孙？（中山靖王刘胜之后）");
        topic.add("操曾带刀闯入十长侍中谁的府bai邸？（张让）");
        topic.add("云初式与那位主君？（袁绍）");
        topic.add("备被陆逊火烧连营七百里后感叹若是谁在的话自己就不会有此大败？（法正）");
        topic.add("禅被称为中国四大美女之之，请问“貂禅”在东汉时期是什么意思？（宫廷掌灯侍女）");
        topic.add("操运用了什么计谋打败了马超？（离间计）");
        topic.add("壁之战时庞统去曹操那献连环计被谁识破？（徐庶）");
        topic.add("东猛将为救孙权身中N刀的是谁？（周泰）");
        topic.add("葛亮和诸葛恪是什么关系？（叔侄）");
        topic.add("关羽带兵攻打长沙时，韩玄命谁射杀关羽？（黄忠）");
        topic.add("张飞善与什么艺术？（书法与绘画）");
        topic.add("吕布帐下首席猛将是何人？（高顺）");
        topic.add("张鲁在汉中传播什么文化？（五斗米道）");
        topic.add("“苍天已死，黄天当立”下面两句是什么？（岁在甲子，天下大吉）");
        topic.add("曹操官渡之战胜利后，袁氏兄弟逃亡辽东，谁劝曹操莫要追击？（郭嘉遗书中写的）");
        topic.add("江夏八俊为哪八人？（刘表、张隐、薛郁、王访、宣靖、（公褚恭）〔公绪恭〕、刘祗、田林）");
        topic.add("曹操因父仇起兵攻打徐州时，除刘备等人前往救援外谁也去了？（太史慈）");
        topic.add("诸葛亮北伐时，李严因何罪被斩？（延误粮草）");
        topic.add("刘备与白马将军公孙瓒还有什么特殊的关系？（两个人都曾师从卢植）");
        topic.add("谁才是三国里的真英雄？（只要不被《三国演义》贻害，各抒己见都没问题）");
        topic.add("官渡之战发生在哪一年？(200年)");
        topic.add(" 以逸待劳是蜀军攻打定军山时谁提出的计谋：（法正）");
        topic.add("吕布听了王允的话杀了谁？ 董卓");
        topic.add("草船借箭中每条船上多少人？ 三十人");
        topic.add("孙权称帝后，下列何者被任命丞相? 顾雍");
        topic.add("孔明最后一次北伐时病死在哪里? 五丈原");
        topic.add("洛神赋其中洛神是意指谁的妻子? 曹丕");
        topic.add("黄巾贼程志远为何人所杀? 关羽");
        topic.add("诸葛亮隐居时常把自己比作? 管仲和乐毅");
        topic.add("请问曾经当过刘备军师的「单福」其实是何人? 徐庶");
        topic.add("夏侯敦被何人射去一眼? 曹性");
        topic.add("使张辽成名的战役是什么? 逍遥津之役");
        topic.add("使赵云成名的战役是什么? 长板坡之役");
        topic.add("刘备最先派给庞统的职位是? 县令");
        topic.add("赤壁之战始于西元几年? 208");
        topic.add("关公的座骑赤兔马原本是属于谁的? 董卓");
        topic.add("群雄讨伐董卓，在泗水关迎战联军的大将是谁?: 华雄");
        topic.add("关羽在曹军时先斩杀了哪一位袁军大将? 颜良");
        topic.add("三国演义中，第一个死在张飞丈八蛇矛之下:是? 邓茂");
        topic.add("袁绍手下哪位谋士倒投曹操并献计火烧乌巢粮仓? 许攸");
        topic.add("诸葛亮发明的运输工具叫作? 木牛流马");
        topic.add("曹操的父亲名字是? 曹嵩");
        topic.add("何人建议袁绍「挟天子以令诸侯」但被拒绝? 沮授");
        topic.add("本欲夺去关羽的赤兔马，但在知道是关羽后即归顺的是? 裴元绍");
        topic.add("曹操的乳名? 阿瞒");
        topic.add("欲将守寡多年嫂子樊氏嫁与赵云,但是惹得赵云大怒的是? 赵范");
        topic.add("诸葛亮在南阳隐居了几年 10年");
        topic.add("诸葛亮在五丈元死后,把国家大事托付给谁? 杨仪");
        topic.add("孟获夫人是谁？ 祝融");
        topic.add("三分天下，最后被谁统一 司马炎");
        topic.add("关羽过五关斩六将斩的最后一将是谁？ 秦淇");
        topic.add("曾与张飞，许褚大战而不分胜负的西凉猛将是 马超");
        topic.add("张飞喝断当阳桥，吓死了谁？ 夏侯杰");
        topic.add("与马腾结为异姓兄弟，后被马超砍断左手的是？韩遂");
        topic.add("九品官人制是谁提出的? 陈群");
        topic.add("五虎大将中的黄忠 原为谁的手下？ 韩玄");
        topic.add("曹仁的八门金锁阵是谁破的 徐庶");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_random) {
            int index = new Random().nextInt(topic.size());
            String title = topic.get(index);
            tvTitle.setText(title);
            tts.speak(title, TextToSpeech.QUEUE_FLUSH, null);
        } else if (view.getId() == R.id.btn_setting) {
            startActivity(new Intent("com.android.settings.TTS_SETTINGS"));
        }
    }
}
