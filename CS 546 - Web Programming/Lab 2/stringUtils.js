const camelcase = function camelcase(s) {
    if(s==undefined) throw 'error'
    if(typeof s!=='string') throw 'Not a string'
    var n = s.length;

    var st= s.toLowerCase()
	var str="";
	for (var i = 0; i < n; i++)
	{
        if (st[i] == ' ')
		{
			str+= st[i+1].toUpperCase();
			i++;	
		}
		else{
            str+= st[i];
			}
	}
	return str;
}

function replceChar(s){
    if(s==undefined) throw 'Provide parameter'
    if(s==="") throw 'String is empty'
    if(typeof s!=='string') throw 'Not a string'
    var n =s.length
    var st=s.charAt(0).toLowerCase()
    var str= s.charAt(0)
    var count=0
    for(var i=1;i<n;i++){
        if(s[i]===s.charAt(0) || s[i]===st){
        count++
        if(count%2==0){
            str+="$"
        }
        else{
            str+="*"}
        }
        else
        str+=s[i]
    }
    return str
}

function mashUp(s1, s2) {
//    if(s1===undefined || s2===undefined) throw 'invalid string'
    if(typeof s1 != 'string' || typeof s2 !='string') throw 'not a string or provide a string'
    if(s1.length>=2 && s2.length>=2){
        var str=" "+s1.charAt(0)+s1.charAt(1)
        var st =s2.charAt(0)+s2.charAt(1)
        var s=""
        for(var i=2;i<s1.length;i++){
            st=st+s1.charAt(i)
        }
        for(var i=2;i<s2.length;i++){
            str=str+s2.charAt(i)
        }
        return st + str
    }
    else throw 'invalid string'
}

module.exports = {
    camelcase,
    replceChar,
    mashUp
}