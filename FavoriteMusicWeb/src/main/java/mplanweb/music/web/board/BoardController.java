package mplanweb.music.web.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mplanweb.music.web.AdminController;
import mplanweb.music.web.etc.BoardLogger;
import mplanweb.music.web.etc.BoardStringUtil;
import mplanweb.music.web.etc.ResultJSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class BoardController extends BoardLogger {

	@Autowired
	private BoardService BoardService;

	@RequestMapping(value = "/jquery", method = RequestMethod.GET)
	protected String showJqueryPage(HttpServletRequest request, Model model) {

		Device device = DeviceUtils.getCurrentDevice(request);
		model.addAttribute("yboard", new Board()); // 초기세션처리를 위해 디폴트 처리
		if (device.isNormal()) {
			return "/jquery/yboard";
		} else {
			return "/jquery/yboard_mobile";
		}

	}

	@RequestMapping(value = "/angular", method = RequestMethod.GET)
	protected String showAngularPage(Model model) {
		model.addAttribute("yboard", new Board()); // 초기세션처리를 위해 디폴트 처리
		return "/angular/yboard";
	}

	/**
	 * yboard리스트: 파라미터를 json형태로 받고 결과를 json형태로 출력
	 * 
	 * @param yboard
	 * @return
	 */
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON selectYboard(@RequestBody BoardSearch boardSearch) {
		ResultJSON resultJSON = new ResultJSON();
		int totalCount = BoardService.selectTotalCountYboard(boardSearch);
		List<Board> yboardList = BoardService.selectYboard(boardSearch);
		resultJSON.setTotal(totalCount);
		resultJSON.setItems(yboardList);
		resultJSON.setSuccess(true);
		return resultJSON;
	}

	/**
	 * yboard 입력
	 * 
	 * @param yboard
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON insertYboard(@RequestBody Board board) {
		ResultJSON resultJSON = new ResultJSON();
		BoardService.insertYboard(board);
		resultJSON.setSuccess(true);
		return resultJSON;
	}

	/**
	 * yboard에서 체크된 값들 삭제처리
	 * 
	 * @param boardIDs
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON deleteYboard(@RequestBody Map<String, Object> param) {
		ResultJSON resultJSON = new ResultJSON();
		String boardIDs = String.valueOf(param.get("boardIDs"));
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] boardIDEncrypts = boardIDs.split(",");
		for (String boardIDEncrypt : boardIDEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardID",
					BoardStringUtil.getTmsDecryptoAesForInt(boardIDEncrypt));
			mapList.add(map);
		}
		BoardService.deleteYboard(mapList);
		resultJSON.setSuccess(true);
		return resultJSON;
	}

	/**
	 * yboard 보기
	 * 
	 * @param boardIDs
	 * @return
	 */
	@RequestMapping(value = "/view/{boardIDEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON viewYboard(@PathVariable String boardIDEncrypt) {
		ResultJSON resultJSON = new ResultJSON();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardID",
				BoardStringUtil.getTmsDecryptoAesForInt(boardIDEncrypt));
		resultJSON.setData(BoardService.viewYboard(map));
		resultJSON.setSuccess(true);
		return resultJSON;
	}

	/**
	 * yboard 수정처리
	 * 
	 * @param boardIDs
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON updateYboard(@RequestBody Board board) {
		ResultJSON resultJSON = new ResultJSON();
		board.setBoardID(BoardStringUtil.getTmsDecryptoAesForInt(board
				.getBoardIDEncrypt()));
		BoardService.updateYboard(board);
		resultJSON.setSuccess(true);
		return resultJSON;
	}

}
