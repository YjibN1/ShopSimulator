package load

//return Regex("""\w*""").find(str)?.value
//Regex("""\(.*\)""").replace(this.toString(), "")
fun Any.nameOf() =
    "${this::class.simpleName}" //qualifiedName


/*
fun ProductDescription.toProductRecord() =
    ProductRecord(this.name, this.number)*/
