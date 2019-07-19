def genPushSh(Map params){
    return replace(params.params, params.push)
}

def genBuildSh(Map params) {
    // params.script = 'docker pull ${OriginalImage} && docker tag ${OriginalImage} ${REGISTRY}/${OWNER}/${ImageName}'
    // params.params = ['REGISTRY':'index.alauda.cn','OWNER':'alaudaorg','ImageName':'base-notebook','OriginalImage':'jupyter/base-notebook']
    return replace(params.params, params.script)
}

def replace(Map map, String string) {
    for (def data : map) {
        string = string.replace("\${" + data.getKey() + "}", data.getValue().toString())
    }
    return string
}

// println genBuildSh([:])
// def tt = 'docker pull ${OriginalImage} && docker tag ${OriginalImage} ${REGISTRY}/${OWNER}/${ImageName}'
// def pp= ['REGISTRY':'index.alauda.cn','OWNER':'alaudaorg','ImageName':'base-notebook','OriginalImage':'jupyter/base-notebook']
// def out = replace(pp,tt)
// println out