
package cn.exam.util;

import java.util.List;

/**
 * 回调函数
 * @File: CallBack
 * @Author:
 * @Date: 2018/5/15 15:03
 * @Description: 回调函数
 */
public interface CallBack<T> {
	/**
	 * 回调函数
	 */
    List<T> callBack();
}
