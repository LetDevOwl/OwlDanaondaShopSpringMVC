package kr.co.danaonda.notice.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.danaonda.notice.domain.Notice;
import kr.co.danaonda.notice.domain.PageInfo;
import kr.co.danaonda.notice.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService service;

	@RequestMapping(value = "/notice/insert.do", method = RequestMethod.GET)
	public String showInsertForm() {
		return "notice/insert";
	}

	@RequestMapping(value = "/notice/insert.do", method = RequestMethod.POST)
	public String insertNotice(@ModelAttribute Notice notice,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest request,
			Model model) {
		try {
			if (uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> nMap = this.saveFile(uploadFile, request);
				String fileName = (String) nMap.get("fileName");
				String fileReName = (String) nMap.get("fileReName");
				String savePath = (String) nMap.get("filePath");
				long fileLength = (long) nMap.get("fileLength");
				// DB에 저장하기 위해 notice에 데이터를 Set하는 부분

				notice.setNoticeFilename(fileName);
				notice.setNoticeFileRename(fileReName);
				notice.setNoticeFilepath(savePath);
				notice.setNoticeFilelength(fileLength);
			}
			int result = service.insertNotice(notice);
			if (result > 0) {
				return "redirect:/notice/list.do";
			} else {
				model.addAttribute("msg", "공지사항 등록이 	완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 등록 실패");
				model.addAttribute("url", "/notice/insert.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/modify.do", method = RequestMethod.GET)
	public String showModifyForm(
			@RequestParam("noticeNo") Integer noticeNo
			, Model model) {
		Notice noticeOne = service.selectNoticeByNo(noticeNo);
		model.addAttribute("noticeOne", noticeOne);
		return "notice/modify";
	}
	
	@RequestMapping(value="notice/modify.do", method=RequestMethod.POST)
	public String updateNotice(
			@ModelAttribute Notice notice
			, @RequestParam(value="uploadFile", required = false) MultipartFile uploadFile
			, Model model
			, HttpServletRequest request) {
		try {
			if (uploadFile != null && !uploadFile.isEmpty()) {
				String fileName = notice.getNoticeFileRename();
				if(fileName != null) {
					this.deleteFile(request, fileName);
				}
				Map<String, Object> infoMap = this.saveFile(uploadFile, request);
				String noticeFilename = (String)infoMap.get("fileName");
				long noticeFilelength = (long)infoMap.get("fileLength");
				notice.setNoticeFilename(noticeFilename);
				notice.setNoticeFileRename((String)infoMap.get("fileReName"));
				notice.setNoticeFilepath((String)infoMap.get("filePath"));
				notice.setNoticeFilelength(noticeFilelength);
			}
			int result = service.updateNotice(notice);
			if(result > 0) {
				return "redirect:/notice/detail.do?noticeNo="+notice.getNoticeNo();
			}else {
				model.addAttribute("msg", "공지사항 수정이 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 수정 실패");
				model.addAttribute("url", "/notice/list.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/delete.do", method = RequestMethod.GET)
	public String deleteNotice(@RequestParam("noticeNo") int noticeNo, Model model) {
		try {
			int result = service.deleteNotice(noticeNo);
			if (result > 0) {
				return "redirect:/notice/list.do";
			} else {
				model.addAttribute("msg", "공지사항 삭제 실패했습니다.");
				model.addAttribute("error", "공지사항 삭제 실패");
				model.addAttribute("url", "/notice/list.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}

	}

	@RequestMapping(value = "/notice/search.do", method = RequestMethod.GET)
	public String searchNoticeList(@RequestParam("searchCondition") String searchCondition,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage, Model model) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		int totalCount = service.getListCount(paramMap);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Notice> searchList = service.searchNoticesByKeyword(pInfo, paramMap);
		if (!searchList.isEmpty()) {
			model.addAttribute("pInfo", pInfo);
			model.addAttribute("searchCondition", searchCondition);
			model.addAttribute("searchKeyword", searchKeyword);
			model.addAttribute("sList", searchList);
			return "notice/search";
		} else {
			model.addAttribute("msg", "공지사항 조회가 완료되지 않았습니다.");
			model.addAttribute("error", "공지사항 제목으로 조회 실패");
			model.addAttribute("url", "/notice/list.do");
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/list.do", method = RequestMethod.GET)
	public String showNoticeList(
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage, Model model) {
		try {
			int totalCount = service.getListCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<Notice> nList = service.selectNoticeList(pInfo);
			if (nList.size() > 0) {
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("nList", nList);
				return "notice/list";
			} else {
				model.addAttribute("msg", "공지사항 조회가 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 목록 조회 실패");
				model.addAttribute("url", "/notice/insert.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/notice/detail.do", method = RequestMethod.GET)
	public String showDetailNotice(@RequestParam("noticeNo") int noticeNo, Model model) {
		try {
			Notice notice = service.selectOneById(noticeNo);
			if (notice != null) {
				model.addAttribute("notice", notice);
				return "notice/detail";
			} else {
				model.addAttribute("msg", "공지사항 조회가 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 조회 실패");
				model.addAttribute("url", "/notice/list.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}

	public PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;

		naviTotalCount = (int) ((double) totalCount / recordCountPage + 0.9);
		startNavi = (((int) ((double) currentPage / naviCountPerPage + 0.9)) - 1) * naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage - 1;
		if (endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, recordCountPage, naviCountPerPage, startNavi, endNavi, totalCount,
				naviTotalCount);
		return pi;
	}

	private Map<String, Object> saveFile(MultipartFile uploadFile, HttpServletRequest request) throws Exception {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String fileName = uploadFile.getOriginalFilename();
		String root = request.getSession().getServletContext().getRealPath("resources");
		String saveFolder = root + "\\nuploadFiles";
		File folder = new File(saveFolder);
		if (!folder.exists()) {
			folder.mkdir();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDDHHmmss"); // 나중에 SS랑 비교
		String strResult = sdf.format(new Date(System.currentTimeMillis()));
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1); // .을 포함하지 않고 자름 +1
		String fileReName = "N" + strResult + "." + ext;
		String savePath = saveFolder + "\\" + fileReName;
		File file = new File(savePath);
		uploadFile.transferTo(file);
		long fileLength = uploadFile.getSize();
		infoMap.put("fileName", fileName);
		infoMap.put("fileReName", fileReName);
		infoMap.put("filePath", savePath);
		infoMap.put("fileLength", fileLength);
		return infoMap;
	}

	private void deleteFile(HttpServletRequest request, String fileName) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String delFilepath = root+"\\nuploadFiles\\"+fileName;
		File file = new File(delFilepath);
		if(file.exists()) {
			file.delete();
		}
	}
}
