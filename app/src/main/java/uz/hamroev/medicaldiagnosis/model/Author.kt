package uz.hamroev.medicaldiagnosis.model

class Author {
    var author_name: String? = null
    var author_prof: String? = null
    var author_image: Int? = null

    constructor(author_name: String?, author_prof: String?, author_image: Int?) {
        this.author_name = author_name
        this.author_prof = author_prof
        this.author_image = author_image
    }
}