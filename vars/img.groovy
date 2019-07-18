def genPushSh(Map params){
    def engine = new groovy.text.SimpleTemplateEngine()
    def template = engine.createTemplate(params.push).make(params.params)
    return template.toString()
}

def genBuildSh(Map params) {
    // params.script = 'docker pull ${OriginalImage} && docker tag ${OriginalImage} ${REGISTRY}/${OWNER}/${ImageName}'
    // params.params = ['REGISTRY':'index.alauda.cn','OWNER':'alaudaorg','ImageName':'base-notebook','OriginalImage':'jupyter/base-notebook']
    def engine = new groovy.text.SimpleTemplateEngine()
    def template = engine.createTemplate(params.script).make(params.params)
    return template.toString()
}

def replace(String str, from,to){
    def _from = printf("\${%s}",from)
    return str.replaceAll(_from,to)
}

def test(){
    def tt = 'docker pull ${OriginalImage} && docker tag ${OriginalImage} ${REGISTRY}/${OWNER}/${ImageName}'
    def pp= ['REGISTRY':'index.alauda.cn','OWNER':'alaudaorg','ImageName':'base-notebook','OriginalImage':'jupyter/base-notebook']

    pp.each{ k,v->
        println(k)
        tt = replace(tt,k,v)
    }
    println tt

}

// test()
// def tt = 'docker pull ${OriginalImage} && docker tag ${OriginalImage} ${REGISTRY}/${OWNER}/${ImageName}'
// tt.replaceAll('{REGISTRY}',"aaa")

println genBuildSh([:])