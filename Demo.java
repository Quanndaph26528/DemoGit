/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DanhMuc;
import model.TaiKhoan;
import model.Vo;
import model.XemBaoCao;

/**
 *
 * @author FPT Shop
 */
public class VoRepository {

    public List<TaiKhoan> dsAllTK() throws SQLException {
        List<TaiKhoan> listTK = new ArrayList<>();

        Connection conn = DBContext.getConnection();
        String sql = "select TenDangNhap, MatKhau, VaiTro from TaiKhoan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String tenTK = rs.getString(1);
            String matKhau = rs.getString(2);
            String vaiTro = rs.getString(3);
            TaiKhoan tk = new TaiKhoan(tenTK, matKhau, vaiTro);
            listTK.add(tk);
        }
        rs.close();
        ps.close();
        conn.close();
        return listTK;
    }

//    public List<DanhMuc> dsAllDanhMuc() throws SQLException{
//        List<DanhMuc> listDanhMuc = new ArrayList<>();
//        
//        Connection conn = DBContext.getConnection();
//        String sql = "select MaDanhMuc, TenDanhMuc from DanhMuc";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        
//        while(rs.next()){
//            Integer maDM = rs.getInt(1);
//            String tenDM = rs.getString(2);
//            DanhMuc danhMuc = new DanhMuc(maDM, tenDM);
//            listDanhMuc.add(danhMuc);
//        }
//        rs.close();
//        ps.close();
//        conn.close();
//        return listDanhMuc;
//    }
//    
    public List<Vo> dsAllTopicAssignment() throws SQLException {
        List<Vo> listt = new ArrayList<>();

        Connection conn = DBContext.getConnection();
        String sql = "select MaSanPham, MaDanhMuc, TenSanPham, GiaHienTai, SoLuongHienCo, KhaNangSinhCon, MucDoChieuChong "
                + "from TopicAssignment ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Integer maSP = rs.getInt(1);
            Integer maDM = rs.getInt(2);
            String tenSP = rs.getString(3);
            BigDecimal giaHienTai = rs.getBigDecimal(4);
            Integer soLuongHienCo = rs.getInt(5);
            String khaNangSinhCon = rs.getString(6);
            String mucDoChieuChong = rs.getString(7);

            Vo topic = new Vo();
            topic.setMaDanhMuc(maDM);
            topic.setMaSanPham(maSP);
            topic.setTenSanPham(tenSP);
            topic.setGiaHienTai(giaHienTai);
            topic.setSoLuongHienCo(soLuongHienCo);
            topic.setKhaNangSinhCon(khaNangSinhCon);
            topic.setMucDoChieuChong(mucDoChieuChong);

            listt.add(topic);
        }
        rs.close();
        ps.close();
        conn.close();
        return listt;
    }

    public List<Vo> timKiemSPTheoTen(String ten) throws SQLException {
        List<Vo> listt = new ArrayList<>();

        Connection conn = DBContext.getConnection();
        String sql = "select MaSanPham, MaDanhMuc, TenSanPham, GiaHienTai, SoLuongHienCo, KhaNangSinhCon, MucDoChieuChong "
                + "from TopicAssignment where TenSanPham like ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, ten);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Integer maSP = rs.getInt(1);
            Integer maDM = rs.getInt(2);
            String tenSP = rs.getString(3);
            BigDecimal giaHienTai = rs.getBigDecimal(4);
            Integer soLuongHienCo = rs.getInt(5);
            String khaNangSinhCon = rs.getString(6);
            String mucDoChieuChong = rs.getString(7);

            Vo topic = new Vo();
            topic.setMaDanhMuc(maDM);
            topic.setMaSanPham(maSP);
            topic.setTenSanPham(tenSP);
            topic.setGiaHienTai(giaHienTai);
            topic.setSoLuongHienCo(soLuongHienCo);
            topic.setKhaNangSinhCon(khaNangSinhCon);
            topic.setMucDoChieuChong(mucDoChieuChong);

            listt.add(topic);
        }
        rs.close();
        ps.close();
        conn.close();
        return listt;
    }
//    
//    public List<NhatKyXuatNhapTon> dsAllXuatNhap() throws SQLException{
//        List<NhatKyXuatNhapTon> listt = new ArrayList<>();
//        
//        Connection conn = DBContext.getConnection();
//        String sql = "select MaSanPham, NgayXuatNhap, DanhDauNhapXuat, SoLuong, DonGia from NhatKyXuatNhapTon";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        
//        while(rs.next()){
//            Integer maSP = rs.getInt(1);
//            String ngayXuatNhap = rs.getString(2);
//            Integer bitDanhDauNhapXuat = rs.getInt(3);
//            Integer soLuongHienCo = rs.getInt(4);
//            BigDecimal donGia = rs.getBigDecimal(5);
//            NhatKyXuatNhapTon xuatNhap = new NhatKyXuatNhapTon(maSP, ngayXuatNhap, bitDanhDauNhapXuat, soLuongHienCo, donGia);
//            listt.add(xuatNhap);
//        }
//        rs.close();
//        ps.close();
//        conn.close();
//        return listt;
//    }

    public List<String> maDanhMuc() throws SQLException {
        List<String> listt = new ArrayList<>();

        Connection conn = DBContext.getConnection();
        String sql = "select MaDanhMuc from DanhMuc";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String maDM = String.valueOf(rs.getInt(1));
            listt.add(maDM);
        }
        return listt;
    }

    public List<String> maSanPhamTheoDanhMuc(Integer maDanhMuc) throws SQLException {
        List<String> listt = new ArrayList<>();

        Connection conn = DBContext.getConnection();
        String sql = "select MaSanPham from TopicAssignment join DanhMuc on "
                + "TopicAssignment.MaDanhMuc=DanhMuc.MaDanhMuc where DanhMuc.MaDanhMuc = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, maDanhMuc);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String maSP = String.valueOf(rs.getInt("MaSanPham"));
            listt.add(maSP);
        }
        rs.close();
        ps.close();
        conn.close();
        return listt;
    }

    public List<XemBaoCao> top10SPtonKho() throws SQLException {
        List<XemBaoCao> listt = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "Select top(10) NhatKyXuatNhapTon.MaSanPham,TenSanPham, GiaHienTai, SoLuong, DonGia, NgayXuatNhap, DanhDauNhapXuat\n"
                + "FROM NhatKyXuatNhapTon JOIN TopicAssignment on NhatKyXuatNhapTon.MaSanPham=TopicAssignment.MaSanPham\n"
                + "order by NgayXuatNhap asc";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Integer maSP = rs.getInt(1);
            String tenSP = rs.getString(2);
            BigDecimal giaHienTai = rs.getBigDecimal(3);
            Integer soLuong = rs.getInt(4);
            BigDecimal donGia = rs.getBigDecimal(5);
            String ngayXuatNhap = rs.getString(6);
            Integer bitNhapXuat = rs.getInt(7);
            
            Vo sp = new Vo();
            sp.setMaSanPham(maSP);
            sp.setTenSanPham(tenSP);
            sp.setGiaHienTai(giaHienTai);
            
            XemBaoCao baoCao = new XemBaoCao();
            baoCao.setSoLuong(soLuong);
            baoCao.setDonGia(donGia);
            baoCao.setNgayXuatNhap(ngayXuatNhap);
            baoCao.setSanPham(sp);
            baoCao.setDanhDauNhapXuat(bitNhapXuat);
            
            listt.add(baoCao);
        }
        return listt;
    }

    public List<Vo> timSanPhamTheoDanhMuc(Integer maDanhMuc) throws SQLException {
        List<Vo> listt = new ArrayList<>();

        Connection conn = DBContext.getConnection();
        String sql = "select * from TopicAssignment join DanhMuc on "
                + "TopicAssignment.MaDanhMuc=DanhMuc.MaDanhMuc where DanhMuc.MaDanhMuc = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, maDanhMuc);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Integer maSP = rs.getInt(1);
            Integer maDM = rs.getInt(2);
            String tenSP = rs.getString(3);
            BigDecimal giaHienTai = rs.getBigDecimal(4);
            Integer soLuongHienCo = rs.getInt(5);
            String khaNangSinhCon = rs.getString(6);
            String mucDoChieuChong = rs.getString(7);

            Vo vo = new Vo();
            vo.setMaDanhMuc(maDM);
            vo.setMaSanPham(maSP);
            vo.setTenSanPham(tenSP);
            vo.setGiaHienTai(giaHienTai);
            vo.setSoLuongHienCo(soLuongHienCo);
            vo.setKhaNangSinhCon(khaNangSinhCon);
            vo.setMucDoChieuChong(mucDoChieuChong);

            listt.add(vo);
        }
        rs.close();
        ps.close();
        conn.close();
        return listt;
    }

    public TaiKhoan getAccountByUsername(String tenTK) throws SQLException {

        for (TaiKhoan tk : dsAllTK()) {

            if (tk.getTenTaiKhoan().equalsIgnoreCase(tenTK)) {
                return tk;
            }
        }
        //Nếu không tìm thấy thì trả về null
        return null;
    }

    public void setAllSoLuong(Integer soLuongHienCo, Integer maSanPham) throws SQLException {
        Connection conn = DBContext.getConnection();
        String sql = "update TopicAssignment SET SoLuongHienCo = ? where  MaSanPham= ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, soLuongHienCo);
        ps.setInt(2, maSanPham);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void themNhatKy(Integer maSP, Integer nhapOrXuat, Integer soLuong, BigDecimal donGia) throws SQLException {
        Connection conn = DBContext.getConnection();
        String sql = "Insert NhatKyXuatNhapTon (MaSanPham, NgayXuatNhap, DanhDauNhapXuat, SoLuong, DonGia) values (?,GETDATE(),?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, maSP);
        ps.setInt(2, nhapOrXuat);
        ps.setInt(3, soLuong);
        ps.setBigDecimal(4, donGia);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void themSP(Integer maDM, String tenVo, BigDecimal giaHienTai, Integer soLuong, String khaNangSinhCon, String mucDoChieuChong) throws SQLException {
        Connection conn = DBContext.getConnection();
        String sql = "Insert TopicAssignment (MaDanhMuc, TenSanPham, GiaHienTai, SoLuongHienCo, KhaNangSinhCon, MucDoChieuChong) values (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, maDM);
        ps.setString(2, tenVo);
        ps.setBigDecimal(3, giaHienTai);
        ps.setInt(4, soLuong);
        ps.setString(5, khaNangSinhCon);
        ps.setString(6, mucDoChieuChong);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void updateSP(Integer maDM, String tenVo, BigDecimal giaHienTai, Integer soLuong, String khaNangSinhCon, String mucDoChieuChong, Integer maSanPham) throws SQLException {
        Connection conn = DBContext.getConnection();
        String sql = "UPDATE TopicAssignment set MaDanhMuc = ?, TenSanPham = ?, GiaHienTai = ?, SoLuongHienCo = ?, KhaNangSinhCon = ?, MucDoChieuChong = ? where MaSanPham = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, maDM);
        ps.setString(2, tenVo);
        ps.setBigDecimal(3, giaHienTai);
        ps.setInt(4, soLuong);
        ps.setString(5, khaNangSinhCon);
        ps.setString(6, mucDoChieuChong);
        ps.setInt(7, maSanPham);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public Integer xoaSP(Integer maSP) throws SQLException {
        Connection conn = DBContext.getConnection();
        String sql = "DELETE NhatKyXuatNhapTon where MaSanPham = ?\n"
                + "DELETE TopicAssignment where MaSanPham = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, maSP);
        ps.setInt(2, maSP);
        ps.executeUpdate();
        ps.close();
        conn.close();
        return ps.executeUpdate();
    }

}
