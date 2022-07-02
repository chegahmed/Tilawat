package com.example.tilawat.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.example.tilawat.Model.QuranSurah;
import com.example.tilawat.Util.Constants;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db ) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `quran_surah` (\n" +
                "\t`id`\tINTEGER NOT NULL UNIQUE,\n" +
                "\t`arabic`\tTEXT NOT NULL,\n" +
                "\t`latin`\tTEXT NOT NULL,\n" +
                "\t`english`\tTEXT NOT NULL,\n" +
                "\t`localtion`\tTEXT NOT NULL,\n" +
                "\t`sajda`\tTEXT NOT NULL,\n" +
                "\t`ayah`\tINTEGER NOT NULL,\n" +
                "\t`nameFile`\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(`id`)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }


    public void insertAllSourat() {
        System.err.println("START insertAllSourat ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO\n" +
                "  `quran_surah` (\n" +
                "    `id`,\n" +
                "    `arabic`,\n" +
                "    `latin`,\n" +
                "    `english`,\n" +
                "    `localtion`,\n" +
                "    `sajda`,\n" +
                "    `ayah`,\n" +
                "    `nameFile`\n" +
                "  )\n" +
                "VALUES\n" +
                "  (\n" +
                "    1,\n" +
                "    'سورة الفاتحة',\n" +
                "    'Al-Fatiha',\n" +
                "    'The Opening',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    7,\n" +
                "    '001-al-fatihah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    2,\n" +
                "    'سورة البقرة',\n" +
                "    'Al-Baqara',\n" +
                "    'The Cow',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    286,\n" +
                "    '002-al-baqarah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    3,\n" +
                "    'سورة آل عمران',\n" +
                "    'Aal-e-Imran',\n" +
                "    'The family of Imran',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    200,\n" +
                "    '003-al-imran.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    4,\n" +
                "    'سورة النساء',\n" +
                "    'An-Nisa',\n" +
                "    'The Women',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    176,\n" +
                "    '004-an-nisa.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    5,\n" +
                "    'سورة المائدة',\n" +
                "    'Al-Maeda',\n" +
                "    'The Table Spread',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    120,\n" +
                "    '005-al-maidah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    6,\n" +
                "    'سورة الأنعام',\n" +
                "    'Al-Anaam',\n" +
                "    'The cattle',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    165,\n" +
                "    '006-al-anam.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    7,\n" +
                "    'سورة الأعراف',\n" +
                "    'Al-Araf',\n" +
                "    'The heights',\n" +
                "    '1',\n" +
                "    '206',\n" +
                "    206,\n" +
                "    '007-al-araf.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    8,\n" +
                "    'سورة الأنفال',\n" +
                "    'Al-Anfal',\n" +
                "    'Spoils of war, booty',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    75,\n" +
                "    '008-al-anfal.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    9,\n" +
                "    'سورة التوبة',\n" +
                "    'At-Taubah',\n" +
                "    'Repentance',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    129,\n" +
                "    '009-at-taubah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    10,\n" +
                "    'سورة يونس',\n" +
                "    'Yunus',\n" +
                "    'Jonah',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    109,\n" +
                "    '010-yunus.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    11,\n" +
                "    'سورة هود',\n" +
                "    'Hud',\n" +
                "    'Hud',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    123,\n" +
                "    '011-hud.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    12,\n" +
                "    'سورة يوسف',\n" +
                "    'Yusuf',\n" +
                "    'Joseph',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    111,\n" +
                "    '012-yusuf.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    13,\n" +
                "    'سورة الرعد',\n" +
                "    'Ar-Rad',\n" +
                "    'The Thunder',\n" +
                "    '1',\n" +
                "    '15',\n" +
                "    43,\n" +
                "    '013-ar-rad.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    14,\n" +
                "    'سورة إبراهيم',\n" +
                "    'Ibrahim',\n" +
                "    'Abraham',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    52,\n" +
                "    '014-ibrahim.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    15,\n" +
                "    'سورة الحجر',\n" +
                "    'Al-Hijr',\n" +
                "    'Stoneland, Rock city, Al-Hijr valley',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    99,\n" +
                "    '015-al-hijr.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    16,\n" +
                "    'سورة النحل',\n" +
                "    'An-Nahl',\n" +
                "    'The Bee',\n" +
                "    '1',\n" +
                "    '50',\n" +
                "    128,\n" +
                "    '016-an-nahl.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    17,\n" +
                "    'سورة الإسراء',\n" +
                "    'Al-Isra',\n" +
                "    'The night journey',\n" +
                "    '1',\n" +
                "    '100',\n" +
                "    111,\n" +
                "    '017-al-isra.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    18,\n" +
                "    'سورة الكهف',\n" +
                "    'Al-Kahf',\n" +
                "    'The cave',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    110,\n" +
                "    '018-al-kahf.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    19,\n" +
                "    'سورة مريم',\n" +
                "    'Maryam',\n" +
                "    'Mary',\n" +
                "    '1',\n" +
                "    '58',\n" +
                "    98,\n" +
                "    '019-maryam.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    20,\n" +
                "    'سورة طه',\n" +
                "    'Taha',\n" +
                "    'Taha',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    135,\n" +
                "    '020-ta-ha.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    21,\n" +
                "    'سورة الأنبياء',\n" +
                "    'Al-Anbiya',\n" +
                "    'The Prophets',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    112,\n" +
                "    '021-al-anbiya.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    22,\n" +
                "    'سورة الحج',\n" +
                "    'Al-Hajj',\n" +
                "    'The Pilgrimage',\n" +
                "    '1',\n" +
                "    '18',\n" +
                "    78,\n" +
                "    '022-al-hajj.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    23,\n" +
                "    'سورة المؤمنون',\n" +
                "    'Al-Mumenoon',\n" +
                "    'The Believers',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    118,\n" +
                "    '023-al-muminun.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    24,\n" +
                "    'سورة النور',\n" +
                "    'An-Noor',\n" +
                "    'The Light',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    64,\n" +
                "    '024-an-nur.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    25,\n" +
                "    'سورة الفرقان',\n" +
                "    'Al-Furqan',\n" +
                "    'The Standard',\n" +
                "    '1',\n" +
                "    '60',\n" +
                "    77,\n" +
                "    '025-al-furqan.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    26,\n" +
                "    'سورة الشعراء',\n" +
                "    'Ash-Shuara',\n" +
                "    'The Poets',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    227,\n" +
                "    '026-ash-shuara.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    27,\n" +
                "    'سورة النمل',\n" +
                "    'An-Naml',\n" +
                "    'THE ANT',\n" +
                "    '1',\n" +
                "    '26',\n" +
                "    93,\n" +
                "    '027-an-naml.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    28,\n" +
                "    'سورة القصص',\n" +
                "    'Al-Qasas',\n" +
                "    'The Story',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    88,\n" +
                "    '028-al-qasas.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    29,\n" +
                "    'سورة العنكبوت',\n" +
                "    'Al-Ankaboot',\n" +
                "    'The Spider',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    69,\n" +
                "    '029-al-ankabut.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    30,\n" +
                "    'سورة الروم',\n" +
                "    'Ar-Room',\n" +
                "    'The Romans',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    60,\n" +
                "    '030-ar-rum.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    31,\n" +
                "    'سورة لقمان',\n" +
                "    'Luqman',\n" +
                "    'Luqman',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    34,\n" +
                "    '031-luqman.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    32,\n" +
                "    'سورة السجدة',\n" +
                "    'As-Sajda',\n" +
                "    'The Prostration',\n" +
                "    '1',\n" +
                "    '15',\n" +
                "    30,\n" +
                "    '032-as-sajdah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    33,\n" +
                "    'سورة الأحزاب',\n" +
                "    'Al-Ahzab',\n" +
                "    'The Coalition',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    73,\n" +
                "    '033-al-ahzab.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    34,\n" +
                "    'سورة سبأ',\n" +
                "    'Saba',\n" +
                "    'Saba',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    54,\n" +
                "    '034-saba.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    35,\n" +
                "    'سورة فاطر',\n" +
                "    'Fatir',\n" +
                "    'Originator',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    45,\n" +
                "    '035-fatir.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    36,\n" +
                "    'سورة يس',\n" +
                "    'Ya Seen',\n" +
                "    'Ya Seen',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    83,\n" +
                "    '036-ya-sin.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    37,\n" +
                "    'سورة الصافات',\n" +
                "    'As-Saaffat',\n" +
                "    'Those who set the ranks',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    182,\n" +
                "    '037-as-saffat.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    38,\n" +
                "    'سورة ص',\n" +
                "    'Sad',\n" +
                "    'Sad',\n" +
                "    '1',\n" +
                "    '24',\n" +
                "    88,\n" +
                "    '038-sad.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    39,\n" +
                "    'سورة الزمر',\n" +
                "    'Az-Zumar',\n" +
                "    'The Troops',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    75,\n" +
                "    '039-az-zumar.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    40,\n" +
                "    'سورة غافر',\n" +
                "    'Ghafir',\n" +
                "    'The Forgiver',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    85,\n" +
                "    '040-ghafir.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    41,\n" +
                "    'سورة فصلت',\n" +
                "    'Fussilat',\n" +
                "    'Explained in detail',\n" +
                "    '1',\n" +
                "    '38',\n" +
                "    54,\n" +
                "    '041-fussilat.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    42,\n" +
                "    'سورة الشورى',\n" +
                "    'Ash-Shura',\n" +
                "    'Council, Consultation',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    53,\n" +
                "    '042-ash-shura.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    43,\n" +
                "    'سورة الزخرف',\n" +
                "    'Az-Zukhruf',\n" +
                "    'Ornaments of Gold',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    89,\n" +
                "    '043-az-zukhruf.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    44,\n" +
                "    'سورة الدخان',\n" +
                "    'Ad-Dukhan',\n" +
                "    'The Smoke',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    59,\n" +
                "    '044-ad-dukhan.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    45,\n" +
                "    'سورة الجاثية',\n" +
                "    'Al-Jathiya',\n" +
                "    'Crouching',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    37,\n" +
                "    '045-al-jathiyah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    46,\n" +
                "    'سورة الأحقاف',\n" +
                "    'Al-Ahqaf',\n" +
                "    'The wind-curved sandhills',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    35,\n" +
                "    '046-al-ahqaf.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    47,\n" +
                "    'سورة محمد',\n" +
                "    'Muhammad',\n" +
                "    'Muhammad',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    38,\n" +
                "    '047-muhammad.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    48,\n" +
                "    'سورة الفتح',\n" +
                "    'Al-Fath',\n" +
                "    'The victory',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    29,\n" +
                "    '048-al-fath.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    49,\n" +
                "    'سورة الحجرات',\n" +
                "    'Al-Hujraat',\n" +
                "    'The private apartments',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    18,\n" +
                "    '049-al-hujurat.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    50,\n" +
                "    'سورة ق',\n" +
                "    'Qaf',\n" +
                "    'Qaf',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    45,\n" +
                "    '050-qaf.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    51,\n" +
                "    'سورة الذاريات',\n" +
                "    'Adh-Dhariyat',\n" +
                "    'The winnowing winds',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    60,\n" +
                "    '051-adh-dhariyat.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    52,\n" +
                "    'سورة الطور',\n" +
                "    'At-tur',\n" +
                "    'Mount Sinai',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    49,\n" +
                "    '052-at-tur.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    53,\n" +
                "    'سورة النجم',\n" +
                "    'An-Najm',\n" +
                "    'The Star',\n" +
                "    '1',\n" +
                "    '62',\n" +
                "    62,\n" +
                "    '053-an-najm.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    54,\n" +
                "    'سورة القمر',\n" +
                "    'Al-Qamar',\n" +
                "    'The moon',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    55,\n" +
                "    '054-al-qamar.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    55,\n" +
                "    'سورة الرحمن',\n" +
                "    'Al-Rahman',\n" +
                "    'The Beneficient',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    78,\n" +
                "    '055-ar-rahman.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    56,\n" +
                "    'سورة الواقعة',\n" +
                "    'Al-Waqia',\n" +
                "    'The Event, The Inevitable',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    96,\n" +
                "    '056-al-waqiah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    57,\n" +
                "    'سورة الحديد',\n" +
                "    'Al-Hadid',\n" +
                "    'The Iron',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    29,\n" +
                "    '057-al-hadid.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    58,\n" +
                "    'سورة المجادلة',\n" +
                "    'Al-Mujadila',\n" +
                "    'She that disputes',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    22,\n" +
                "    '058-al-mujadilah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    59,\n" +
                "    'سورة الحشر',\n" +
                "    'Al-Hashr',\n" +
                "    'Exile',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    24,\n" +
                "    '059-al-hashr.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    60,\n" +
                "    'سورة الممتحنة',\n" +
                "    'Al-Mumtahina',\n" +
                "    'She that is to be examined',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    13,\n" +
                "    '060-al-mumtahanah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    61,\n" +
                "    'سورة الصف',\n" +
                "    'As-Saff',\n" +
                "    'The Ranks',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    14,\n" +
                "    '061-as-saff.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    62,\n" +
                "    'سورة الجمعة',\n" +
                "    'Al-Jumua',\n" +
                "    'The congregation, Friday',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    11,\n" +
                "    '062-al-jumuah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    63,\n" +
                "    'سورة المنافقون',\n" +
                "    'Al-Munafiqoon',\n" +
                "    'The Hypocrites',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    11,\n" +
                "    '063-al-munafiqun.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    64,\n" +
                "    'سورة التغابن',\n" +
                "    'At-Taghabun',\n" +
                "    'Mutual Disillusion',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    18,\n" +
                "    '064-at-taghabun.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    65,\n" +
                "    'سورة الطلاق',\n" +
                "    'At-Talaq',\n" +
                "    'Divorce',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    12,\n" +
                "    '065-at-talaq.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    66,\n" +
                "    'سورة التحريم',\n" +
                "    'At-Tahrim',\n" +
                "    'Banning',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    12,\n" +
                "    '066-at-tahrim.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    67,\n" +
                "    'سورة الملك',\n" +
                "    'Al-Mulk',\n" +
                "    'The Sovereignty',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    30,\n" +
                "    '067-al-mulk.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    68,\n" +
                "    'سورة القلم',\n" +
                "    'Al-Qalam',\n" +
                "    'The Pen',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    52,\n" +
                "    '068-al-qalam.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    69,\n" +
                "    'سورة الحاقة',\n" +
                "    'Al-Haaqqa',\n" +
                "    'The reality',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    52,\n" +
                "    '069-al-haqqah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    70,\n" +
                "    'سورة المعارج',\n" +
                "    'Al-Maarij',\n" +
                "    'The Ascending stairways',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    44,\n" +
                "    '070-al-maarij.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    71,\n" +
                "    'سورة نوح',\n" +
                "    'Nooh',\n" +
                "    'Nooh',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    28,\n" +
                "    '071-nuh.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    72,\n" +
                "    'سورة الجن',\n" +
                "    'Al-Jinn',\n" +
                "    'The Jinn',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    28,\n" +
                "    '072-al-jinn.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    73,\n" +
                "    'سورة المزمل',\n" +
                "    'Al-Muzzammil',\n" +
                "    'The enshrouded one',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    20,\n" +
                "    '073-al-muzammil.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    74,\n" +
                "    'سورة المدثر',\n" +
                "    'Al-Muddathir',\n" +
                "    'The cloaked one',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    56,\n" +
                "    '074-al-muddaththir.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    75,\n" +
                "    'سورة القيامة',\n" +
                "    'Al-Qiyama',\n" +
                "    'The rising of the dead',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    40,\n" +
                "    '075-al-qiyamah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    76,\n" +
                "    'سورة الإنسان',\n" +
                "    'Al-Insan',\n" +
                "    'The man',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    31,\n" +
                "    '076-al-insan.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    77,\n" +
                "    'سورة المرسلات',\n" +
                "    'Al-Mursalat',\n" +
                "    'The emissaries',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    50,\n" +
                "    '077-al-mursalat.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    78,\n" +
                "    'سورة النبأ',\n" +
                "    'An-Naba',\n" +
                "    'The tidings',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    40,\n" +
                "    '078-an-naba.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    79,\n" +
                "    'سورة النازعات',\n" +
                "    'An-Naziat',\n" +
                "    'Those who drag forth',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    46,\n" +
                "    '079-an-naziat.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    80,\n" +
                "    'سورة عبس',\n" +
                "    'Abasa',\n" +
                "    'He Frowned',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    42,\n" +
                "    '080-abasa.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    81,\n" +
                "    'سورة التكوير',\n" +
                "    'At-Takwir',\n" +
                "    'The Overthrowing',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    29,\n" +
                "    '081-at-takwir.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    82,\n" +
                "    'سورة الإنفطار',\n" +
                "    'AL-Infitar',\n" +
                "    'The Cleaving',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    19,\n" +
                "    '082-al-infitar.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    83,\n" +
                "    'سورة المطففين',\n" +
                "    'Al-Mutaffifin',\n" +
                "    'Defrauding',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    36,\n" +
                "    '083-al-mutaffifin.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    84,\n" +
                "    'سورة الانشقاق',\n" +
                "    'Al-Inshiqaq',\n" +
                "    'The Sundering, Splitting Open',\n" +
                "    '1',\n" +
                "    '21',\n" +
                "    25,\n" +
                "    '084-al-inshiqaq.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    85,\n" +
                "    'سورة البروج',\n" +
                "    'Al-Burooj',\n" +
                "    'The Mansions of the stars',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    22,\n" +
                "    '085-al-buruj.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    86,\n" +
                "    'سورة الطارق',\n" +
                "    'At-Tariq',\n" +
                "    'The morning star',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    17,\n" +
                "    '086-at-tariq.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    87,\n" +
                "    'سورة الأعلى',\n" +
                "    'Al-Ala',\n" +
                "    'The Most High',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    19,\n" +
                "    '087-al-ala.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    88,\n" +
                "    'سورة الغاشية',\n" +
                "    'Al-Ghashiya',\n" +
                "    'The Overwhelming',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    26,\n" +
                "    '088-al-ghashiyah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    89,\n" +
                "    'سورة الفجر',\n" +
                "    'Al-Fajr',\n" +
                "    'The Dawn',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    30,\n" +
                "    '089-al-fajr.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    90,\n" +
                "    'سورة البلد',\n" +
                "    'Al-Balad',\n" +
                "    'The City',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    20,\n" +
                "    '090-al-balad.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    91,\n" +
                "    'سورة الشمس',\n" +
                "    'Ash-Shams',\n" +
                "    'The Sun',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    15,\n" +
                "    '091-ash-shams.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    92,\n" +
                "    'سورة الليل',\n" +
                "    'Al-Lail',\n" +
                "    'The night',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    21,\n" +
                "    '092-al-lail.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    93,\n" +
                "    'سورة الضحى',\n" +
                "    'Ad-Dhuha',\n" +
                "    'The morning hours',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    11,\n" +
                "    '093-ad-duha.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    94,\n" +
                "    'سورة الشرح',\n" +
                "    'Al-Inshirah',\n" +
                "    'Solace',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    8,\n" +
                "    '094-ash-sharh.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    95,\n" +
                "    'سورة التين',\n" +
                "    'At-Tin',\n" +
                "    'The Fig',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    8,\n" +
                "    '095-at-tin.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    96,\n" +
                "    'سورة العلق',\n" +
                "    'Al-Alaq',\n" +
                "    'The Clot',\n" +
                "    '1',\n" +
                "    '19',\n" +
                "    19,\n" +
                "    '096-al-alaq.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    97,\n" +
                "    'سورة القدر',\n" +
                "    'Al-Qadr',\n" +
                "    'The Power',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    5,\n" +
                "    '097-al-qadr.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    98,\n" +
                "    'سورة البينة',\n" +
                "    'Al-Bayyina',\n" +
                "    'The Clear proof',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    8,\n" +
                "    '098-al-baiyyinah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    99,\n" +
                "    'سورة الزلزلة',\n" +
                "    'Al-Zalzala',\n" +
                "    'The earthquake',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    8,\n" +
                "    '099-az-zalzalah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    100,\n" +
                "    'سورة العاديات',\n" +
                "    'Al-Adiyat',\n" +
                "    'The Chargers',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    11,\n" +
                "    '100-al-adiyat.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    101,\n" +
                "    'سورة القارعة',\n" +
                "    'Al-Qaria',\n" +
                "    'The Calamity',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    11,\n" +
                "    '101-al-qariah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    102,\n" +
                "    'سورة التكاثر',\n" +
                "    'At-Takathur',\n" +
                "    'Competition',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    8,\n" +
                "    '102-at-takathur.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    103,\n" +
                "    'سورة العصر',\n" +
                "    'Al-Asr',\n" +
                "    'The declining day',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    3,\n" +
                "    '103-al-asr.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    104,\n" +
                "    'سورة الهمزة',\n" +
                "    'Al-Humaza',\n" +
                "    'The Traducer',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    9,\n" +
                "    '104-al-humazah.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    105,\n" +
                "    'سورة الفيل',\n" +
                "    'Al-fil',\n" +
                "    'The Elephant',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    5,\n" +
                "    '105-al-fil.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    106,\n" +
                "    'سورة قريش',\n" +
                "    'Quraish',\n" +
                "    'Quraish',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    4,\n" +
                "    '106-quraish.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    107,\n" +
                "    'سورة الماعون',\n" +
                "    'Al-Maun',\n" +
                "    'Alms Giving',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    7,\n" +
                "    '107-al-maun.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    108,\n" +
                "    'سورة الكوثر',\n" +
                "    'Al-Kauther',\n" +
                "    'Abundance',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    3,\n" +
                "    '108-al-kauthar.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    109,\n" +
                "    'سورة الكافرون',\n" +
                "    'Al-Kafiroon',\n" +
                "    'The Disbelievers',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    6,\n" +
                "    '109-al-kafirun.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    110,\n" +
                "    'سورة النصر',\n" +
                "    'An-Nasr',\n" +
                "    'The Succour',\n" +
                "    '2',\n" +
                "    '0',\n" +
                "    3,\n" +
                "    '110-an-nasr.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    111,\n" +
                "    'سورة المسد',\n" +
                "    'Al-Masadd',\n" +
                "    'The Flame',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    5,\n" +
                "    '111-al-masad.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    112,\n" +
                "    'سورة الإخلاص',\n" +
                "    'Al-Ikhlas',\n" +
                "    'Absoluteness',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    4,\n" +
                "    '112-al-ikhlas.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    113,\n" +
                "    'سورة الفلق',\n" +
                "    'Al-Falaq',\n" +
                "    'The day break',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    5,\n" +
                "    '113-al-falaq.mp3'\n" +
                "  ),\n" +
                "  (\n" +
                "    114,\n" +
                "    'سورة الناس',\n" +
                "    'An-Nas',\n" +
                "    'The mankind',\n" +
                "    '1',\n" +
                "    '0',\n" +
                "    6,\n" +
                "    '114-an-nas.mp3'\n" +
                "  );\n");
        System.err.println("END insertAllSourat ");
    }

    //getAll QuranSurahs;
    public List<QuranSurah> getAllQuranSurahs() {
        System.out.println("END getAllQuranSurahs ");
        SQLiteDatabase db = this.getWritableDatabase();

        List<QuranSurah> quranSurahtList = new ArrayList<>();
        //select all quranSurahtList

        String selectAll = "SELECT * FROM " + Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        //Loop throogh our QuranSurah
        if (cursor.moveToFirst()) {
            do {
                QuranSurah QuranSurah = new QuranSurah();
                if (!TextUtils.isEmpty(cursor.getString(0)) && TextUtils.isDigitsOnly(cursor.getString(0))) {
                    QuranSurah.setId(Integer.parseInt(cursor.getString(0)));
                }
                QuranSurah.setArabic(cursor.getString(1));
                QuranSurah.setLatin(cursor.getString(2));
                QuranSurah.setEnglish(cursor.getString(3));
                QuranSurah.setLocaltion(cursor.getString(4));
                QuranSurah.setSajda(cursor.getString(5));
                QuranSurah.setAyah(Integer.parseInt(cursor.getString(6)));
                QuranSurah.setNameFile(cursor.getString(7));

                System.out.println("QuranSurah Id  : "+QuranSurah.getId()+" QuranSurah arabic  : "+QuranSurah.getArabic()+" ");

                // add our object to our QuranSurah list
                quranSurahtList.add(QuranSurah);

            } while (cursor.moveToNext());
        }

        return quranSurahtList;
    }


    //get QuranSurah by id
    public QuranSurah getQuranSurah(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME, new String[]{
                        Constants.KEY_ID, Constants.KEY_ARABIC, Constants.KEY_LATIN,Constants.KEY_ENGLISH,
                        Constants.KEY_LOCATION, Constants.KEY_SAJDA, Constants.KEY_AYAH,Constants.KEY_NAME_FILE}, Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        QuranSurah quranSurah = new QuranSurah(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2),cursor.getString(3),
        cursor.getString(4), cursor.getString(5),Integer.parseInt(cursor.getString(6)),cursor.getString(7));

        return quranSurah;
    }


}
