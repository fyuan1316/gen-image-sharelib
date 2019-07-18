def genPushSh(Map params){

    return 

}

def genBuildSh(Map params) {
    // params.script = 'docker pull ${OriginalImage} && docker tag ${OriginalImage} ${REGISTRY}/${OWNER}/${ImageName}'
    // params.params = ['REGISTRY':'index.alauda.cn','OWNER':'alaudaorg','ImageName':'base-notebook','OriginalImage':'jupyter/base-notebook']
    def engine = new groovy.text.SimpleTemplateEngine()
    def template = engine.createTemplate(params.script).make(params.params)
    return template.toString()
}