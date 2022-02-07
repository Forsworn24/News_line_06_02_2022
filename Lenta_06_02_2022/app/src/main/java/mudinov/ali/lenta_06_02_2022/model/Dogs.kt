package mudinov.ali.lenta_06_02_2022.model

data class Dogs(
    var name: String? = null,
    var temperament: String? = null,
    var height: Height? = null,
    var image: Image?
)

class Image{
    var url: String? = null
}

class Height {
    var metric: String? = null
}
