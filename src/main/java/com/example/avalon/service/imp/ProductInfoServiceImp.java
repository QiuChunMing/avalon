package com.example.avalon.service.imp;

import com.example.avalon.dto.CartDTO;
import com.example.avalon.entity.ProductInfo;
import com.example.avalon.enums.ProductStatus;
import com.example.avalon.enums.ResultEnum;
import com.example.avalon.exception.SellException;
import com.example.avalon.repository.ProductInfoRepository;
import com.example.avalon.service.IProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ProductInfoServiceImp implements IProductInfoService {

    @Autowired
    private ProductInfoRepository infoRepository;

    @Override
    public ProductInfo findOne(Integer productId) {
        return infoRepository.findByProductId(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return infoRepository.findByProductStatus(ProductStatus.UP.getCode());

    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return infoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        productInfo.setUpdateTime(LocalDate.now());
        return infoRepository.save(productInfo);

    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = infoRepository.findByProductId(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            infoRepository.save(productInfo);
        }
    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = infoRepository.findByProductId(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            infoRepository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(Integer productId) {
        ProductInfo productInfo = infoRepository.findByProductId(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatus() == ProductStatus.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatus.UP.getCode());
        productInfo.setUpdateTime(LocalDate.now());
        return infoRepository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(Integer productId) {
        ProductInfo productInfo = infoRepository.findByProductId(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatus() == ProductStatus.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatus.DOWN.getCode());
        productInfo.setUpdateTime(LocalDate.now());
        return infoRepository.save(productInfo);
    }
}
