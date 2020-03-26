const host = require('../../../../config').host
var app = getApp()

import F2 from '../../resources/f2-canvas/lib/f2';

let chart = null;

var dataVal = [];
var ticksVal = [];

function initChart(canvas, width, height) {
  var data = dataVal;

  chart = new F2.Chart({
    el: canvas,
    width,
    height
  });

  chart.source(data, {
    day: {
      ticks: ticksVal
    },
    value: {
      min: 0
    }
  });

  chart.tooltip({
    custom: true, // 自定义 tooltip 内容框
    onChange(obj) {
      var legend = chart.get('legendController').legends.top[0];
      var tooltipItems = obj.items;
      var legendItems = legend.items;
      var map = {};
      legendItems.map(item => {
        map[item.name] = Object.assign({}, item);
      });
      tooltipItems.map(item => {
        var { name, value } = item;
        if (map[name]) {
          map[name].value = value;
        }
      });
      legend.setItems(Object.values(map));
    },
    onHide() {
      var legend = chart.get('legendController').legends.top[0];
      legend.setItems(chart.getLegendItems().country);
    }
  });

  chart.line().position('day*value').color('type', val => { });
  chart.render();
  return chart;
}



Page({

  /**
   * 页面的初始数据
   */
  data: {
    category: null,
    opts: {
      onInit: initChart
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var category = options.category;
    this.setData({
      category: category,
      categoryShow: category.toUpperCase()
    });
    dataVal = wx.getStorageSync('data').practiceChart[category].data;
    ticksVal = wx.getStorageSync('data').practiceChart[category].day;
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function (e) {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
})