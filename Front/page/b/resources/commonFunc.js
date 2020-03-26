var select = ['a','b','c','d'];
function generateTopic(value) {
  var topic = new Object();
  var options = [];
  var arr = [];
  //定义一个while循环，循环的条件是集合arr的子集少于4个
  while (arr.length < 4) {
    var t = Math.floor(Math.random() * 4);//生成随机数
    if (arr.indexOf(t) == -1) {
      //如果t在集合arr中存在，indexOf会返回t在集合arr中的位置。
      //如果不存在，indexOf会返回-1
      arr.push(t);    //把生成的数字放进这个数组里
    }
  }
  for (var i in arr) {
    var option = new Object();
    var char = select[arr[i]];
    option.k = char;
    option.v = value[char];
    options.push(option);
  }
  topic.q = value.q;
  topic.a = value.a;
  topic.b = value.b;
  topic.c = value.c;
  topic.d = value.d;
  topic.pic = value.p;
  topic.options = options;
  return topic;
}

module.exports = {
  generateTopic: generateTopic
}