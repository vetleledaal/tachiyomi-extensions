package eu.kanade.tachiyomi.extension.es.ikifeng

import eu.kanade.tachiyomi.multisrc.madara.Madara
import eu.kanade.tachiyomi.source.model.SChapter
import okhttp3.Response
import java.text.SimpleDateFormat
import java.util.Locale

class Ikifeng : Madara("Ikifeng", "https://lectorunm.life", "es", SimpleDateFormat("dd/MM/yyyy", Locale("es"))) {
    override val useNewChapterEndpoint = true

    override fun searchPage(page: Int): String = if (page == 1) "" else "page/$page/"

    override fun chapterListParse(response: Response): List<SChapter> {
        return super.chapterListParse(response).reversed()
    }
}
